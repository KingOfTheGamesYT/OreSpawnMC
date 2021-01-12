/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.CaveFisher;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelCaveFisher
/*     */   extends ModelBase
/*     */ {
/*  25 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Nose;
/*     */   
/*     */   ModelRenderer EyeLeft;
/*     */   ModelRenderer HeadMid;
/*     */   ModelRenderer HeadEnd;
/*     */   ModelRenderer TailTuft;
/*     */   ModelRenderer EyeRight;
/*     */   ModelRenderer BodyTopLeft4;
/*     */   ModelRenderer BodyTopRight4;
/*     */   ModelRenderer BodyTopLeft1;
/*     */   ModelRenderer BodyTopRight1;
/*     */   ModelRenderer BodyTopRight2;
/*     */   ModelRenderer BodyTopLeft2;
/*     */   ModelRenderer BodyTopRight3;
/*     */   ModelRenderer BodyTopLeft3;
/*     */   ModelRenderer HeadBase;
/*     */   ModelRenderer TailBase;
/*     */   ModelRenderer BodyLow2;
/*     */   ModelRenderer BodyLow1;
/*     */   ModelRenderer Spine5;
/*     */   ModelRenderer Spine1;
/*     */   ModelRenderer Spine2;
/*     */   ModelRenderer Spine3;
/*     */   ModelRenderer Spine4;
/*     */   ModelRenderer RightArmSeg4;
/*     */   ModelRenderer LeftArmSeg1;
/*     */   ModelRenderer LeftArmSeg3;
/*     */   ModelRenderer RightArmSeg2;
/*     */   ModelRenderer RightArmSeg1;
/*     */   ModelRenderer LeftArmSeg5;
/*     */   ModelRenderer LeftArmSeg2;
/*     */   ModelRenderer LeftClawTop;
/*     */   ModelRenderer RightArmSeg3;
/*     */   ModelRenderer RightArmSeg5;
/*     */   ModelRenderer LeftArmSeg4;
/*     */   ModelRenderer LeftClawBase;
/*     */   ModelRenderer RightClawBase;
/*     */   ModelRenderer LeftClawLow;
/*     */   ModelRenderer RightClawTop;
/*     */   ModelRenderer RightClawLow;
/*     */   ModelRenderer LBLeg1;
/*     */   ModelRenderer LBLeg3;
/*     */   ModelRenderer RBLeg1;
/*     */   ModelRenderer RBLeg3;
/*     */   ModelRenderer LBLeg2;
/*     */   ModelRenderer RBLeg2;
/*     */   ModelRenderer LBLeg4;
/*     */   ModelRenderer RBLeg4;
/*     */   ModelRenderer RBLeg5;
/*     */   ModelRenderer LBLeg6;
/*     */   ModelRenderer RBLeg6;
/*     */   ModelRenderer LBLeg5;
/*     */   ModelRenderer RFLeg1;
/*     */   ModelRenderer RFLeg2;
/*     */   ModelRenderer RFLeg3;
/*     */   ModelRenderer RFLeg4;
/*     */   ModelRenderer RFLeg5;
/*     */   ModelRenderer RFLeg6;
/*     */   ModelRenderer RMLeg1;
/*     */   ModelRenderer RMLeg2;
/*     */   ModelRenderer RMLeg3;
/*     */   ModelRenderer RMLeg4;
/*     */   ModelRenderer RMLeg5;
/*     */   ModelRenderer RMLeg6;
/*     */   ModelRenderer LFLeg1;
/*     */   ModelRenderer LFLeg2;
/*     */   ModelRenderer LFLeg3;
/*     */   ModelRenderer LFLeg4;
/*     */   ModelRenderer LFLeg5;
/*     */   ModelRenderer LFLeg6;
/*     */   ModelRenderer LMLeg1;
/*     */   ModelRenderer LMLeg2;
/*     */   ModelRenderer LMLeg4;
/*     */   ModelRenderer LMLeg3;
/*     */   ModelRenderer LMLeg5;
/*     */   ModelRenderer LMLeg6;
/*     */   
/*     */   public ModelCaveFisher(float f1) {
/* 105 */     this.wingspeed = f1;
/*     */     
/* 107 */     this.textureWidth = 64;
/* 108 */     this.textureHeight = 32;
/*     */     
/* 110 */     this.Nose = new ModelRenderer(this, 0, 0);
/* 111 */     this.Nose.addBox(-0.5F, -0.5F, -12.0F, 1, 1, 6);
/* 112 */     this.Nose.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 113 */     this.Nose.setTextureSize(64, 32);
/* 114 */     this.Nose.mirror = true;
/* 115 */     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
/* 116 */     this.EyeLeft = new ModelRenderer(this, 0, 28);
/* 117 */     this.EyeLeft.addBox(0.5F, -2.5F, -2.5F, 3, 2, 2);
/* 118 */     this.EyeLeft.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 119 */     this.EyeLeft.setTextureSize(64, 32);
/* 120 */     this.EyeLeft.mirror = true;
/* 121 */     setRotation(this.EyeLeft, 0.0F, 0.0F, 0.0F);
/* 122 */     this.HeadMid = new ModelRenderer(this, 0, 0);
/* 123 */     this.HeadMid.addBox(-2.5F, -1.5F, -5.0F, 5, 3, 2);
/* 124 */     this.HeadMid.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 125 */     this.HeadMid.setTextureSize(64, 32);
/* 126 */     this.HeadMid.mirror = true;
/* 127 */     setRotation(this.HeadMid, 0.0F, 0.0F, 0.0F);
/* 128 */     this.HeadEnd = new ModelRenderer(this, 0, 0);
/* 129 */     this.HeadEnd.addBox(-2.0F, -1.0F, -6.0F, 4, 2, 1);
/* 130 */     this.HeadEnd.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 131 */     this.HeadEnd.setTextureSize(64, 32);
/* 132 */     this.HeadEnd.mirror = true;
/* 133 */     setRotation(this.HeadEnd, 0.0F, 0.0F, 0.0F);
/* 134 */     this.TailTuft = new ModelRenderer(this, 0, 23);
/* 135 */     this.TailTuft.addBox(-2.0F, -1.0F, 3.0F, 4, 1, 2);
/* 136 */     this.TailTuft.setRotationPoint(0.0F, 19.0F, 10.0F);
/* 137 */     this.TailTuft.setTextureSize(64, 32);
/* 138 */     this.TailTuft.mirror = true;
/* 139 */     setRotation(this.TailTuft, 0.0F, 0.0F, 0.0F);
/* 140 */     this.EyeRight = new ModelRenderer(this, 0, 28);
/* 141 */     this.EyeRight.addBox(-3.5F, -2.5F, -2.5F, 3, 2, 2);
/* 142 */     this.EyeRight.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 143 */     this.EyeRight.setTextureSize(64, 32);
/* 144 */     this.EyeRight.mirror = true;
/* 145 */     setRotation(this.EyeRight, 0.0F, 0.0F, 0.0F);
/* 146 */     this.BodyTopLeft4 = new ModelRenderer(this, 0, 0);
/* 147 */     this.BodyTopLeft4.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4);
/* 148 */     this.BodyTopLeft4.setRotationPoint(0.0F, 16.2F, 7.0F);
/* 149 */     this.BodyTopLeft4.setTextureSize(64, 32);
/* 150 */     this.BodyTopLeft4.mirror = true;
/* 151 */     setRotation(this.BodyTopLeft4, 0.1047198F, 0.1047198F, 0.1047198F);
/* 152 */     this.BodyTopRight4 = new ModelRenderer(this, 0, 0);
/* 153 */     this.BodyTopRight4.addBox(-5.0F, 0.0F, 0.0F, 6, 3, 4);
/* 154 */     this.BodyTopRight4.setRotationPoint(-1.0F, 16.2F, 7.0F);
/* 155 */     this.BodyTopRight4.setTextureSize(64, 32);
/* 156 */     this.BodyTopRight4.mirror = true;
/* 157 */     setRotation(this.BodyTopRight4, 0.1047198F, -0.1047198F, -0.1047198F);
/* 158 */     this.BodyTopLeft1 = new ModelRenderer(this, 0, 0);
/* 159 */     this.BodyTopLeft1.addBox(0.0F, 0.0F, 0.0F, 5, 3, 4);
/* 160 */     this.BodyTopLeft1.setRotationPoint(0.0F, 16.0F, -4.0F);
/* 161 */     this.BodyTopLeft1.setTextureSize(64, 32);
/* 162 */     this.BodyTopLeft1.mirror = true;
/* 163 */     setRotation(this.BodyTopLeft1, 0.1745329F, 0.1745329F, 0.1047198F);
/* 164 */     this.BodyTopRight1 = new ModelRenderer(this, 0, 0);
/* 165 */     this.BodyTopRight1.addBox(-5.0F, 0.0F, 0.0F, 5, 3, 4);
/* 166 */     this.BodyTopRight1.setRotationPoint(0.0F, 16.0F, -4.0F);
/* 167 */     this.BodyTopRight1.setTextureSize(64, 32);
/* 168 */     this.BodyTopRight1.mirror = true;
/* 169 */     setRotation(this.BodyTopRight1, 0.1745329F, -0.1745329F, -0.1047198F);
/* 170 */     this.BodyTopRight2 = new ModelRenderer(this, 0, 0);
/* 171 */     this.BodyTopRight2.addBox(-5.0F, 0.0F, 0.0F, 7, 3, 4);
/* 172 */     this.BodyTopRight2.setRotationPoint(-1.0F, 16.0F, -1.0F);
/* 173 */     this.BodyTopRight2.setTextureSize(64, 32);
/* 174 */     this.BodyTopRight2.mirror = true;
/* 175 */     setRotation(this.BodyTopRight2, 0.2094395F, -0.1745329F, -0.1047198F);
/* 176 */     this.BodyTopLeft2 = new ModelRenderer(this, 0, 0);
/* 177 */     this.BodyTopLeft2.addBox(-1.0F, 0.0F, 0.0F, 7, 3, 4);
/* 178 */     this.BodyTopLeft2.setRotationPoint(0.0F, 16.0F, -1.0F);
/* 179 */     this.BodyTopLeft2.setTextureSize(64, 32);
/* 180 */     this.BodyTopLeft2.mirror = true;
/* 181 */     setRotation(this.BodyTopLeft2, 0.2094395F, 0.1745329F, 0.1047198F);
/* 182 */     this.BodyTopRight3 = new ModelRenderer(this, 0, 0);
/* 183 */     this.BodyTopRight3.addBox(-5.0F, 0.0F, 0.0F, 6, 3, 4);
/* 184 */     this.BodyTopRight3.setRotationPoint(-1.0F, 16.0F, 3.0F);
/* 185 */     this.BodyTopRight3.setTextureSize(64, 32);
/* 186 */     this.BodyTopRight3.mirror = true;
/* 187 */     setRotation(this.BodyTopRight3, 0.1396263F, -0.1396263F, -0.1047198F);
/* 188 */     this.BodyTopLeft3 = new ModelRenderer(this, 0, 0);
/* 189 */     this.BodyTopLeft3.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4);
/* 190 */     this.BodyTopLeft3.setRotationPoint(0.0F, 16.0F, 3.0F);
/* 191 */     this.BodyTopLeft3.setTextureSize(64, 32);
/* 192 */     this.BodyTopLeft3.mirror = true;
/* 193 */     setRotation(this.BodyTopLeft3, 0.1396263F, 0.1396263F, 0.1047198F);
/* 194 */     this.HeadBase = new ModelRenderer(this, 0, 0);
/* 195 */     this.HeadBase.addBox(-3.0F, -2.0F, -3.0F, 6, 4, 3);
/* 196 */     this.HeadBase.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 197 */     this.HeadBase.setTextureSize(64, 32);
/* 198 */     this.HeadBase.mirror = true;
/* 199 */     setRotation(this.HeadBase, 0.0F, 0.0F, 0.0F);
/* 200 */     this.TailBase = new ModelRenderer(this, 0, 0);
/* 201 */     this.TailBase.addBox(-3.0F, -2.0F, 0.0F, 6, 3, 3);
/* 202 */     this.TailBase.setRotationPoint(0.0F, 19.0F, 10.0F);
/* 203 */     this.TailBase.setTextureSize(64, 32);
/* 204 */     this.TailBase.mirror = true;
/* 205 */     setRotation(this.TailBase, 0.0F, 0.0F, 0.0F);
/* 206 */     this.BodyLow2 = new ModelRenderer(this, 34, 0);
/* 207 */     this.BodyLow2.addBox(0.0F, 0.0F, 0.0F, 8, 2, 7);
/* 208 */     this.BodyLow2.setRotationPoint(-4.0F, 18.3F, 3.0F);
/* 209 */     this.BodyLow2.setTextureSize(64, 32);
/* 210 */     this.BodyLow2.mirror = true;
/* 211 */     setRotation(this.BodyLow2, 0.0F, 0.0F, 0.0F);
/* 212 */     this.BodyLow1 = new ModelRenderer(this, 34, 0);
/* 213 */     this.BodyLow1.addBox(0.0F, 0.0F, 0.0F, 8, 2, 7);
/* 214 */     this.BodyLow1.setRotationPoint(-4.0F, 18.7F, -4.0F);
/* 215 */     this.BodyLow1.setTextureSize(64, 32);
/* 216 */     this.BodyLow1.mirror = true;
/* 217 */     setRotation(this.BodyLow1, 0.0F, 0.0F, 0.0F);
/* 218 */     this.Spine5 = new ModelRenderer(this, 0, 0);
/* 219 */     this.Spine5.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 220 */     this.Spine5.setRotationPoint(0.0F, 16.0F, 8.6F);
/* 221 */     this.Spine5.setTextureSize(64, 32);
/* 222 */     this.Spine5.mirror = true;
/* 223 */     setRotation(this.Spine5, 0.0F, 0.0F, 0.0F);
/* 224 */     this.Spine1 = new ModelRenderer(this, 0, 0);
/* 225 */     this.Spine1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 226 */     this.Spine1.setRotationPoint(0.0F, 16.0F, -4.2F);
/* 227 */     this.Spine1.setTextureSize(64, 32);
/* 228 */     this.Spine1.mirror = true;
/* 229 */     setRotation(this.Spine1, 0.2443461F, 0.0F, 0.0F);
/* 230 */     this.Spine2 = new ModelRenderer(this, 0, 0);
/* 231 */     this.Spine2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5);
/* 232 */     this.Spine2.setRotationPoint(0.0F, 16.0F, -1.2F);
/* 233 */     this.Spine2.setTextureSize(64, 32);
/* 234 */     this.Spine2.mirror = true;
/* 235 */     setRotation(this.Spine2, 0.3141593F, 0.0F, 0.0F);
/* 236 */     this.Spine3 = new ModelRenderer(this, 0, 0);
/* 237 */     this.Spine3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 6);
/* 238 */     this.Spine3.setRotationPoint(0.0F, 16.0F, 1.8F);
/* 239 */     this.Spine3.setTextureSize(64, 32);
/* 240 */     this.Spine3.mirror = true;
/* 241 */     setRotation(this.Spine3, 0.2792527F, 0.0F, 0.0F);
/* 242 */     this.Spine4 = new ModelRenderer(this, 0, 0);
/* 243 */     this.Spine4.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 8);
/* 244 */     this.Spine4.setRotationPoint(0.0F, 16.0F, 3.8F);
/* 245 */     this.Spine4.setTextureSize(64, 32);
/* 246 */     this.Spine4.mirror = true;
/* 247 */     setRotation(this.Spine4, 0.1745329F, 0.0F, 0.0F);
/* 248 */     this.RightArmSeg4 = new ModelRenderer(this, 0, 0);
/* 249 */     this.RightArmSeg4.addBox(-3.2F, -1.0F, -10.5F, 2, 2, 4);
/* 250 */     this.RightArmSeg4.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 251 */     this.RightArmSeg4.setTextureSize(64, 32);
/* 252 */     this.RightArmSeg4.mirror = true;
/* 253 */     setRotation(this.RightArmSeg4, 0.0F, 0.0872665F, 0.0F);
/* 254 */     this.LeftArmSeg1 = new ModelRenderer(this, 0, 13);
/* 255 */     this.LeftArmSeg1.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4);
/* 256 */     this.LeftArmSeg1.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 257 */     this.LeftArmSeg1.setTextureSize(64, 32);
/* 258 */     this.LeftArmSeg1.mirror = true;
/* 259 */     setRotation(this.LeftArmSeg1, 0.0F, -0.5235988F, 0.0F);
/* 260 */     this.LeftArmSeg3 = new ModelRenderer(this, 0, 13);
/* 261 */     this.LeftArmSeg3.addBox(1.0F, -0.5F, -8.0F, 1, 1, 3);
/* 262 */     this.LeftArmSeg3.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 263 */     this.LeftArmSeg3.setTextureSize(64, 32);
/* 264 */     this.LeftArmSeg3.mirror = true;
/* 265 */     setRotation(this.LeftArmSeg3, 0.0F, -0.1745329F, 0.0F);
/* 266 */     this.RightArmSeg2 = new ModelRenderer(this, 0, 0);
/* 267 */     this.RightArmSeg2.addBox(-1.5F, -1.0F, -6.0F, 2, 2, 4);
/* 268 */     this.RightArmSeg2.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 269 */     this.RightArmSeg2.setTextureSize(64, 32);
/* 270 */     this.RightArmSeg2.mirror = true;
/* 271 */     setRotation(this.RightArmSeg2, 0.0F, 0.3490659F, 0.0F);
/* 272 */     this.RightArmSeg1 = new ModelRenderer(this, 0, 13);
/* 273 */     this.RightArmSeg1.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4);
/* 274 */     this.RightArmSeg1.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 275 */     this.RightArmSeg1.setTextureSize(64, 32);
/* 276 */     this.RightArmSeg1.mirror = true;
/* 277 */     setRotation(this.RightArmSeg1, 0.0F, 0.5235988F, 0.0F);
/* 278 */     this.LeftArmSeg5 = new ModelRenderer(this, 0, 13);
/* 279 */     this.LeftArmSeg5.addBox(2.4F, -0.5F, -12.0F, 1, 1, 3);
/* 280 */     this.LeftArmSeg5.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 281 */     this.LeftArmSeg5.setTextureSize(64, 32);
/* 282 */     this.LeftArmSeg5.mirror = true;
/* 283 */     setRotation(this.LeftArmSeg5, 0.0F, 0.0F, 0.0F);
/* 284 */     this.LeftArmSeg2 = new ModelRenderer(this, 0, 0);
/* 285 */     this.LeftArmSeg2.addBox(-0.5F, -1.0F, -6.0F, 2, 2, 4);
/* 286 */     this.LeftArmSeg2.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 287 */     this.LeftArmSeg2.setTextureSize(64, 32);
/* 288 */     this.LeftArmSeg2.mirror = true;
/* 289 */     setRotation(this.LeftArmSeg2, 0.0F, -0.3490659F, 0.0F);
/* 290 */     this.LeftClawTop = new ModelRenderer(this, 15, 15);
/* 291 */     this.LeftClawTop.addBox(1.8F, 4.7F, -15.0F, 2, 2, 5);
/* 292 */     this.LeftClawTop.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 293 */     this.LeftClawTop.setTextureSize(64, 32);
/* 294 */     this.LeftClawTop.mirror = true;
/* 295 */     setRotation(this.LeftClawTop, -0.5410521F, 0.0F, 0.0F);
/* 296 */     this.RightArmSeg3 = new ModelRenderer(this, 0, 13);
/* 297 */     this.RightArmSeg3.addBox(-2.0F, -0.5F, -8.0F, 1, 1, 3);
/* 298 */     this.RightArmSeg3.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 299 */     this.RightArmSeg3.setTextureSize(64, 32);
/* 300 */     this.RightArmSeg3.mirror = true;
/* 301 */     setRotation(this.RightArmSeg3, 0.0F, 0.1745329F, 0.0F);
/* 302 */     this.RightArmSeg5 = new ModelRenderer(this, 0, 13);
/* 303 */     this.RightArmSeg5.addBox(-3.6F, -0.5F, -12.0F, 1, 1, 3);
/* 304 */     this.RightArmSeg5.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 305 */     this.RightArmSeg5.setTextureSize(64, 32);
/* 306 */     this.RightArmSeg5.mirror = true;
/* 307 */     setRotation(this.RightArmSeg5, 0.0F, 0.0F, 0.0F);
/* 308 */     this.LeftArmSeg4 = new ModelRenderer(this, 0, 0);
/* 309 */     this.LeftArmSeg4.addBox(1.1F, -1.0F, -10.5F, 2, 2, 4);
/* 310 */     this.LeftArmSeg4.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 311 */     this.LeftArmSeg4.setTextureSize(64, 32);
/* 312 */     this.LeftArmSeg4.mirror = true;
/* 313 */     setRotation(this.LeftArmSeg4, 0.0F, -0.0872665F, 0.0F);
/* 314 */     this.LeftClawBase = new ModelRenderer(this, 0, 0);
/* 315 */     this.LeftClawBase.addBox(1.8F, -1.0F, -13.0F, 2, 2, 2);
/* 316 */     this.LeftClawBase.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 317 */     this.LeftClawBase.setTextureSize(64, 32);
/* 318 */     this.LeftClawBase.mirror = true;
/* 319 */     setRotation(this.LeftClawBase, 0.0F, 0.0F, 0.0F);
/* 320 */     this.RightClawBase = new ModelRenderer(this, 0, 0);
/* 321 */     this.RightClawBase.addBox(-4.2F, -1.0F, -13.0F, 2, 2, 2);
/* 322 */     this.RightClawBase.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 323 */     this.RightClawBase.setTextureSize(64, 32);
/* 324 */     this.RightClawBase.mirror = true;
/* 325 */     setRotation(this.RightClawBase, 0.0F, 0.0F, 0.0F);
/* 326 */     this.LeftClawLow = new ModelRenderer(this, 25, 25);
/* 327 */     this.LeftClawLow.addBox(1.8F, -4.3F, -15.0F, 2, 1, 4);
/* 328 */     this.LeftClawLow.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 329 */     this.LeftClawLow.setTextureSize(64, 32);
/* 330 */     this.LeftClawLow.mirror = true;
/* 331 */     setRotation(this.LeftClawLow, 0.3490659F, 0.0F, 0.0F);
/* 332 */     this.RightClawTop = new ModelRenderer(this, 15, 15);
/* 333 */     this.RightClawTop.addBox(-4.2F, 4.7F, -15.0F, 2, 2, 5);
/* 334 */     this.RightClawTop.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 335 */     this.RightClawTop.setTextureSize(64, 32);
/* 336 */     this.RightClawTop.mirror = true;
/* 337 */     setRotation(this.RightClawTop, -0.5410521F, 0.0F, 0.0F);
/* 338 */     this.RightClawLow = new ModelRenderer(this, 25, 25);
/* 339 */     this.RightClawLow.addBox(-4.2F, -4.3F, -15.0F, 2, 1, 4);
/* 340 */     this.RightClawLow.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 341 */     this.RightClawLow.setTextureSize(64, 32);
/* 342 */     this.RightClawLow.mirror = true;
/* 343 */     setRotation(this.RightClawLow, 0.3490659F, 0.0F, 0.0F);
/* 344 */     this.LBLeg1 = new ModelRenderer(this, 0, 13);
/* 345 */     this.LBLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 346 */     this.LBLeg1.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 347 */     this.LBLeg1.setTextureSize(64, 32);
/* 348 */     this.LBLeg1.mirror = true;
/* 349 */     setRotation(this.LBLeg1, 0.0F, 0.0F, -0.4363323F);
/* 350 */     this.LBLeg3 = new ModelRenderer(this, 2, 0);
/* 351 */     this.LBLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 352 */     this.LBLeg3.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 353 */     this.LBLeg3.setTextureSize(64, 32);
/* 354 */     this.LBLeg3.mirror = true;
/* 355 */     setRotation(this.LBLeg3, 0.0F, 0.0F, -0.5759587F);
/* 356 */     this.RBLeg1 = new ModelRenderer(this, 0, 13);
/* 357 */     this.RBLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 358 */     this.RBLeg1.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 359 */     this.RBLeg1.setTextureSize(64, 32);
/* 360 */     this.RBLeg1.mirror = true;
/* 361 */     setRotation(this.RBLeg1, 0.0F, 0.0F, 0.4363323F);
/* 362 */     this.RBLeg3 = new ModelRenderer(this, 2, 0);
/* 363 */     this.RBLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 364 */     this.RBLeg3.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 365 */     this.RBLeg3.setTextureSize(64, 32);
/* 366 */     this.RBLeg3.mirror = true;
/* 367 */     setRotation(this.RBLeg3, 0.0F, 0.0F, 0.5759587F);
/* 368 */     this.LBLeg2 = new ModelRenderer(this, 0, 0);
/* 369 */     this.LBLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 370 */     this.LBLeg2.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 371 */     this.LBLeg2.setTextureSize(64, 32);
/* 372 */     this.LBLeg2.mirror = true;
/* 373 */     setRotation(this.LBLeg2, 0.0F, 0.0F, -0.9599311F);
/* 374 */     this.RBLeg2 = new ModelRenderer(this, 0, 0);
/* 375 */     this.RBLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 376 */     this.RBLeg2.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 377 */     this.RBLeg2.setTextureSize(64, 32);
/* 378 */     this.RBLeg2.mirror = true;
/* 379 */     setRotation(this.RBLeg2, 0.0F, 0.0F, 0.9599311F);
/* 380 */     this.LBLeg4 = new ModelRenderer(this, 0, 13);
/* 381 */     this.LBLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 382 */     this.LBLeg4.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 383 */     this.LBLeg4.setTextureSize(64, 32);
/* 384 */     this.LBLeg4.mirror = true;
/* 385 */     setRotation(this.LBLeg4, 0.0F, 0.0F, -0.2094395F);
/* 386 */     this.RBLeg4 = new ModelRenderer(this, 0, 13);
/* 387 */     this.RBLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 388 */     this.RBLeg4.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 389 */     this.RBLeg4.setTextureSize(64, 32);
/* 390 */     this.RBLeg4.mirror = true;
/* 391 */     setRotation(this.RBLeg4, 0.0F, 0.0F, 0.2094395F);
/* 392 */     this.RBLeg5 = new ModelRenderer(this, 0, 0);
/* 393 */     this.RBLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 394 */     this.RBLeg5.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 395 */     this.RBLeg5.setTextureSize(64, 32);
/* 396 */     this.RBLeg5.mirror = true;
/* 397 */     setRotation(this.RBLeg5, 0.0F, 0.0F, 0.1047198F);
/* 398 */     this.LBLeg6 = new ModelRenderer(this, 0, 13);
/* 399 */     this.LBLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 400 */     this.LBLeg6.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 401 */     this.LBLeg6.setTextureSize(64, 32);
/* 402 */     this.LBLeg6.mirror = true;
/* 403 */     setRotation(this.LBLeg6, 0.0F, 0.0F, 0.0F);
/* 404 */     this.RBLeg6 = new ModelRenderer(this, 0, 13);
/* 405 */     this.RBLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 406 */     this.RBLeg6.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 407 */     this.RBLeg6.setTextureSize(64, 32);
/* 408 */     this.RBLeg6.mirror = true;
/* 409 */     setRotation(this.RBLeg6, 0.0F, 0.0F, 0.0F);
/* 410 */     this.LBLeg5 = new ModelRenderer(this, 0, 0);
/* 411 */     this.LBLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 412 */     this.LBLeg5.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 413 */     this.LBLeg5.setTextureSize(64, 32);
/* 414 */     this.LBLeg5.mirror = true;
/* 415 */     setRotation(this.LBLeg5, 0.0F, 0.0F, -0.1047198F);
/* 416 */     this.RFLeg1 = new ModelRenderer(this, 0, 13);
/* 417 */     this.RFLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 418 */     this.RFLeg1.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 419 */     this.RFLeg1.setTextureSize(64, 32);
/* 420 */     this.RFLeg1.mirror = true;
/* 421 */     setRotation(this.RFLeg1, 0.0F, 0.0F, 0.4363323F);
/* 422 */     this.RFLeg2 = new ModelRenderer(this, 0, 0);
/* 423 */     this.RFLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 424 */     this.RFLeg2.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 425 */     this.RFLeg2.setTextureSize(64, 32);
/* 426 */     this.RFLeg2.mirror = true;
/* 427 */     setRotation(this.RFLeg2, 0.0F, 0.0F, 0.9599311F);
/* 428 */     this.RFLeg3 = new ModelRenderer(this, 2, 0);
/* 429 */     this.RFLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 430 */     this.RFLeg3.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 431 */     this.RFLeg3.setTextureSize(64, 32);
/* 432 */     this.RFLeg3.mirror = true;
/* 433 */     setRotation(this.RFLeg3, 0.0F, 0.0F, 0.5759587F);
/* 434 */     this.RFLeg4 = new ModelRenderer(this, 0, 13);
/* 435 */     this.RFLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 436 */     this.RFLeg4.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 437 */     this.RFLeg4.setTextureSize(64, 32);
/* 438 */     this.RFLeg4.mirror = true;
/* 439 */     setRotation(this.RFLeg4, 0.0F, 0.0F, 0.2094395F);
/* 440 */     this.RFLeg5 = new ModelRenderer(this, 0, 0);
/* 441 */     this.RFLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 442 */     this.RFLeg5.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 443 */     this.RFLeg5.setTextureSize(64, 32);
/* 444 */     this.RFLeg5.mirror = true;
/* 445 */     setRotation(this.RFLeg5, 0.0F, 0.0F, 0.1047198F);
/* 446 */     this.RFLeg6 = new ModelRenderer(this, 0, 13);
/* 447 */     this.RFLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 448 */     this.RFLeg6.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 449 */     this.RFLeg6.setTextureSize(64, 32);
/* 450 */     this.RFLeg6.mirror = true;
/* 451 */     setRotation(this.RFLeg6, 0.0F, 0.0F, 0.0F);
/* 452 */     this.RMLeg1 = new ModelRenderer(this, 0, 13);
/* 453 */     this.RMLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 454 */     this.RMLeg1.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 455 */     this.RMLeg1.setTextureSize(64, 32);
/* 456 */     this.RMLeg1.mirror = true;
/* 457 */     setRotation(this.RMLeg1, 0.0F, 0.0F, 0.4363323F);
/* 458 */     this.RMLeg2 = new ModelRenderer(this, 0, 0);
/* 459 */     this.RMLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 460 */     this.RMLeg2.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 461 */     this.RMLeg2.setTextureSize(64, 32);
/* 462 */     this.RMLeg2.mirror = true;
/* 463 */     setRotation(this.RMLeg2, 0.0F, 0.0F, 0.9599311F);
/* 464 */     this.RMLeg3 = new ModelRenderer(this, 2, 0);
/* 465 */     this.RMLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 466 */     this.RMLeg3.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 467 */     this.RMLeg3.setTextureSize(64, 32);
/* 468 */     this.RMLeg3.mirror = true;
/* 469 */     setRotation(this.RMLeg3, 0.0F, 0.0F, 0.5759587F);
/* 470 */     this.RMLeg4 = new ModelRenderer(this, 0, 13);
/* 471 */     this.RMLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 472 */     this.RMLeg4.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 473 */     this.RMLeg4.setTextureSize(64, 32);
/* 474 */     this.RMLeg4.mirror = true;
/* 475 */     setRotation(this.RMLeg4, 0.0F, 0.0F, 0.2094395F);
/* 476 */     this.RMLeg5 = new ModelRenderer(this, 0, 0);
/* 477 */     this.RMLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 478 */     this.RMLeg5.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 479 */     this.RMLeg5.setTextureSize(64, 32);
/* 480 */     this.RMLeg5.mirror = true;
/* 481 */     setRotation(this.RMLeg5, 0.0F, 0.0F, 0.1047198F);
/* 482 */     this.RMLeg6 = new ModelRenderer(this, 0, 13);
/* 483 */     this.RMLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 484 */     this.RMLeg6.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 485 */     this.RMLeg6.setTextureSize(64, 32);
/* 486 */     this.RMLeg6.mirror = true;
/* 487 */     setRotation(this.RMLeg6, 0.0F, 0.0F, 0.0F);
/* 488 */     this.LFLeg1 = new ModelRenderer(this, 0, 13);
/* 489 */     this.LFLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 490 */     this.LFLeg1.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 491 */     this.LFLeg1.setTextureSize(64, 32);
/* 492 */     this.LFLeg1.mirror = true;
/* 493 */     setRotation(this.LFLeg1, 0.0F, 0.0F, -0.4363323F);
/* 494 */     this.LFLeg2 = new ModelRenderer(this, 0, 0);
/* 495 */     this.LFLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 496 */     this.LFLeg2.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 497 */     this.LFLeg2.setTextureSize(64, 32);
/* 498 */     this.LFLeg2.mirror = true;
/* 499 */     setRotation(this.LFLeg2, 0.0F, 0.0F, -0.9599311F);
/* 500 */     this.LFLeg3 = new ModelRenderer(this, 2, 0);
/* 501 */     this.LFLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 502 */     this.LFLeg3.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 503 */     this.LFLeg3.setTextureSize(64, 32);
/* 504 */     this.LFLeg3.mirror = true;
/* 505 */     setRotation(this.LFLeg3, 0.0F, 0.0F, -0.5759587F);
/* 506 */     this.LFLeg4 = new ModelRenderer(this, 0, 13);
/* 507 */     this.LFLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 508 */     this.LFLeg4.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 509 */     this.LFLeg4.setTextureSize(64, 32);
/* 510 */     this.LFLeg4.mirror = true;
/* 511 */     setRotation(this.LFLeg4, 0.0F, 0.0F, -0.2094395F);
/* 512 */     this.LFLeg5 = new ModelRenderer(this, 0, 0);
/* 513 */     this.LFLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 514 */     this.LFLeg5.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 515 */     this.LFLeg5.setTextureSize(64, 32);
/* 516 */     this.LFLeg5.mirror = true;
/* 517 */     setRotation(this.LFLeg5, 0.0F, 0.0F, -0.1047198F);
/* 518 */     this.LFLeg6 = new ModelRenderer(this, 0, 13);
/* 519 */     this.LFLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 520 */     this.LFLeg6.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 521 */     this.LFLeg6.setTextureSize(64, 32);
/* 522 */     this.LFLeg6.mirror = true;
/* 523 */     setRotation(this.LFLeg6, 0.0F, 0.0F, 0.0F);
/* 524 */     this.LMLeg1 = new ModelRenderer(this, 0, 13);
/* 525 */     this.LMLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 526 */     this.LMLeg1.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 527 */     this.LMLeg1.setTextureSize(64, 32);
/* 528 */     this.LMLeg1.mirror = true;
/* 529 */     setRotation(this.LMLeg1, 0.0F, 0.0F, -0.4363323F);
/* 530 */     this.LMLeg2 = new ModelRenderer(this, 0, 0);
/* 531 */     this.LMLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 532 */     this.LMLeg2.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 533 */     this.LMLeg2.setTextureSize(64, 32);
/* 534 */     this.LMLeg2.mirror = true;
/* 535 */     setRotation(this.LMLeg2, 0.0F, 0.0F, -0.9599311F);
/* 536 */     this.LMLeg4 = new ModelRenderer(this, 0, 13);
/* 537 */     this.LMLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 538 */     this.LMLeg4.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 539 */     this.LMLeg4.setTextureSize(64, 32);
/* 540 */     this.LMLeg4.mirror = true;
/* 541 */     setRotation(this.LMLeg4, 0.0F, 0.0F, -0.2094395F);
/* 542 */     this.LMLeg3 = new ModelRenderer(this, 2, 0);
/* 543 */     this.LMLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 544 */     this.LMLeg3.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 545 */     this.LMLeg3.setTextureSize(64, 32);
/* 546 */     this.LMLeg3.mirror = true;
/* 547 */     setRotation(this.LMLeg3, 0.0F, 0.0F, -0.5759587F);
/* 548 */     this.LMLeg5 = new ModelRenderer(this, 0, 0);
/* 549 */     this.LMLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 550 */     this.LMLeg5.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 551 */     this.LMLeg5.setTextureSize(64, 32);
/* 552 */     this.LMLeg5.mirror = true;
/* 553 */     setRotation(this.LMLeg5, 0.0F, 0.0F, -0.1047198F);
/* 554 */     this.LMLeg6 = new ModelRenderer(this, 0, 13);
/* 555 */     this.LMLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 556 */     this.LMLeg6.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 557 */     this.LMLeg6.setTextureSize(64, 32);
/* 558 */     this.LMLeg6.mirror = true;
/* 559 */     setRotation(this.LMLeg6, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 566 */     CaveFisher e = (CaveFisher)entity;
/*     */ 
/*     */     
/* 569 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 570 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 571 */     float newangle = 0.0F, upangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */     
/* 574 */     float pi4 = 1.570795F;
/*     */ 
/*     */     
/* 577 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/* 578 */     this.LFLeg1.rotateAngleY = newangle;
/* 579 */     this.LFLeg2.rotateAngleY = newangle;
/* 580 */     this.LFLeg3.rotateAngleY = newangle;
/* 581 */     this.LFLeg4.rotateAngleY = newangle;
/* 582 */     this.LFLeg5.rotateAngleY = newangle;
/* 583 */     this.LFLeg6.rotateAngleY = newangle;
/* 584 */     this.RFLeg1.rotateAngleY = -newangle;
/* 585 */     this.RFLeg2.rotateAngleY = -newangle;
/* 586 */     this.RFLeg3.rotateAngleY = -newangle;
/* 587 */     this.RFLeg4.rotateAngleY = -newangle;
/* 588 */     this.RFLeg5.rotateAngleY = -newangle;
/* 589 */     this.RFLeg6.rotateAngleY = -newangle;
/*     */     
/* 591 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 1.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 592 */     this.LMLeg1.rotateAngleY = newangle;
/* 593 */     this.LMLeg2.rotateAngleY = newangle;
/* 594 */     this.LMLeg3.rotateAngleY = newangle;
/* 595 */     this.LMLeg4.rotateAngleY = newangle;
/* 596 */     this.LMLeg5.rotateAngleY = newangle;
/* 597 */     this.LMLeg6.rotateAngleY = newangle;
/* 598 */     this.RMLeg1.rotateAngleY = -newangle;
/* 599 */     this.RMLeg2.rotateAngleY = -newangle;
/* 600 */     this.RMLeg3.rotateAngleY = -newangle;
/* 601 */     this.RMLeg4.rotateAngleY = -newangle;
/* 602 */     this.RMLeg5.rotateAngleY = -newangle;
/* 603 */     this.RMLeg6.rotateAngleY = -newangle;
/*     */     
/* 605 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 606 */     this.LBLeg1.rotateAngleY = newangle;
/* 607 */     this.LBLeg2.rotateAngleY = newangle;
/* 608 */     this.LBLeg3.rotateAngleY = newangle;
/* 609 */     this.LBLeg4.rotateAngleY = newangle;
/* 610 */     this.LBLeg5.rotateAngleY = newangle;
/* 611 */     this.LBLeg6.rotateAngleY = newangle;
/* 612 */     this.RBLeg1.rotateAngleY = -newangle;
/* 613 */     this.RBLeg2.rotateAngleY = -newangle;
/* 614 */     this.RBLeg3.rotateAngleY = -newangle;
/* 615 */     this.RBLeg4.rotateAngleY = -newangle;
/* 616 */     this.RBLeg5.rotateAngleY = -newangle;
/* 617 */     this.RBLeg6.rotateAngleY = -newangle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 626 */     newangle = MathHelper.cos(f2 * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 627 */     nextangle = MathHelper.cos((f2 + 0.1F) * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */     
/* 629 */     if (e.getAttacking() == 0) {
/* 630 */       newangle = 0.0F;
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
/* 658 */     this.Nose.render(f5);
/* 659 */     this.EyeLeft.render(f5);
/* 660 */     this.HeadMid.render(f5);
/* 661 */     this.HeadEnd.render(f5);
/* 662 */     this.TailTuft.render(f5);
/* 663 */     this.EyeRight.render(f5);
/* 664 */     this.BodyTopLeft4.render(f5);
/* 665 */     this.BodyTopRight4.render(f5);
/* 666 */     this.BodyTopLeft1.render(f5);
/* 667 */     this.BodyTopRight1.render(f5);
/* 668 */     this.BodyTopRight2.render(f5);
/* 669 */     this.BodyTopLeft2.render(f5);
/* 670 */     this.BodyTopRight3.render(f5);
/* 671 */     this.BodyTopLeft3.render(f5);
/* 672 */     this.HeadBase.render(f5);
/* 673 */     this.TailBase.render(f5);
/* 674 */     this.BodyLow2.render(f5);
/* 675 */     this.BodyLow1.render(f5);
/* 676 */     this.Spine5.render(f5);
/* 677 */     this.Spine1.render(f5);
/* 678 */     this.Spine2.render(f5);
/* 679 */     this.Spine3.render(f5);
/* 680 */     this.Spine4.render(f5);
/* 681 */     this.RightArmSeg4.render(f5);
/* 682 */     this.LeftArmSeg1.render(f5);
/* 683 */     this.LeftArmSeg3.render(f5);
/* 684 */     this.RightArmSeg2.render(f5);
/* 685 */     this.RightArmSeg1.render(f5);
/* 686 */     this.LeftArmSeg5.render(f5);
/* 687 */     this.LeftArmSeg2.render(f5);
/* 688 */     this.LeftClawTop.render(f5);
/* 689 */     this.RightArmSeg3.render(f5);
/* 690 */     this.RightArmSeg5.render(f5);
/* 691 */     this.LeftArmSeg4.render(f5);
/* 692 */     this.LeftClawBase.render(f5);
/* 693 */     this.RightClawBase.render(f5);
/* 694 */     this.LeftClawLow.render(f5);
/* 695 */     this.RightClawTop.render(f5);
/* 696 */     this.RightClawLow.render(f5);
/* 697 */     this.LBLeg1.render(f5);
/* 698 */     this.LBLeg3.render(f5);
/* 699 */     this.RBLeg1.render(f5);
/* 700 */     this.RBLeg3.render(f5);
/* 701 */     this.LBLeg2.render(f5);
/* 702 */     this.RBLeg2.render(f5);
/* 703 */     this.LBLeg4.render(f5);
/* 704 */     this.RBLeg4.render(f5);
/* 705 */     this.RBLeg5.render(f5);
/* 706 */     this.LBLeg6.render(f5);
/* 707 */     this.RBLeg6.render(f5);
/* 708 */     this.LBLeg5.render(f5);
/* 709 */     this.RFLeg1.render(f5);
/* 710 */     this.RFLeg2.render(f5);
/* 711 */     this.RFLeg3.render(f5);
/* 712 */     this.RFLeg4.render(f5);
/* 713 */     this.RFLeg5.render(f5);
/* 714 */     this.RFLeg6.render(f5);
/* 715 */     this.RMLeg1.render(f5);
/* 716 */     this.RMLeg2.render(f5);
/* 717 */     this.RMLeg3.render(f5);
/* 718 */     this.RMLeg4.render(f5);
/* 719 */     this.RMLeg5.render(f5);
/* 720 */     this.RMLeg6.render(f5);
/* 721 */     this.LFLeg1.render(f5);
/* 722 */     this.LFLeg2.render(f5);
/* 723 */     this.LFLeg3.render(f5);
/* 724 */     this.LFLeg4.render(f5);
/* 725 */     this.LFLeg5.render(f5);
/* 726 */     this.LFLeg6.render(f5);
/* 727 */     this.LMLeg1.render(f5);
/* 728 */     this.LMLeg2.render(f5);
/* 729 */     this.LMLeg4.render(f5);
/* 730 */     this.LMLeg3.render(f5);
/* 731 */     this.LMLeg5.render(f5);
/* 732 */     this.LMLeg6.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 738 */     model.rotateAngleX = x;
/* 739 */     model.rotateAngleY = y;
/* 740 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 746 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 752 */     this.LeftArmSeg1.rotateAngleX = Math.abs(angle);
/* 753 */     this.LeftArmSeg2.rotateAngleX = Math.abs(angle);
/* 754 */     this.LeftArmSeg3.rotateAngleX = Math.abs(angle);
/* 755 */     this.LeftArmSeg4.rotateAngleX = Math.abs(angle);
/* 756 */     this.LeftArmSeg5.rotateAngleX = Math.abs(angle);
/* 757 */     this.LeftClawBase.rotateAngleX = Math.abs(angle);
/* 758 */     this.LeftClawTop.rotateAngleX = Math.abs(angle) - 0.54F;
/* 759 */     this.LeftClawLow.rotateAngleX = Math.abs(angle) + 0.35F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 764 */     this.RightArmSeg1.rotateAngleX = Math.abs(angle);
/* 765 */     this.RightArmSeg2.rotateAngleX = Math.abs(angle);
/* 766 */     this.RightArmSeg3.rotateAngleX = Math.abs(angle);
/* 767 */     this.RightArmSeg4.rotateAngleX = Math.abs(angle);
/* 768 */     this.RightArmSeg5.rotateAngleX = Math.abs(angle);
/* 769 */     this.RightClawBase.rotateAngleX = Math.abs(angle);
/* 770 */     this.RightClawTop.rotateAngleX = Math.abs(angle) - 0.54F;
/* 771 */     this.RightClawLow.rotateAngleX = Math.abs(angle) + 0.35F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\model\ModelCaveFisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */