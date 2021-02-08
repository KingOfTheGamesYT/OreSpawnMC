/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.CaveFisher;
/*     */ import danger.orespawn.entity.RenderInfo;
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
/*     */ public class ModelCaveFisher
/*     */   extends ModelBase
/*     */ {
/*  25 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Nose;
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
/* 104 */     this.wingspeed = f1;
/*     */     
/* 106 */     this.textureWidth = 64;
/* 107 */     this.textureHeight = 32;
/*     */     
/* 109 */     this.Nose = new ModelRenderer(this, 0, 0);
/* 110 */     this.Nose.addBox(-0.5F, -0.5F, -12.0F, 1, 1, 6);
/* 111 */     this.Nose.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 112 */     this.Nose.setTextureSize(64, 32);
/* 113 */     this.Nose.mirror = true;
/* 114 */     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
/* 115 */     this.EyeLeft = new ModelRenderer(this, 0, 28);
/* 116 */     this.EyeLeft.addBox(0.5F, -2.5F, -2.5F, 3, 2, 2);
/* 117 */     this.EyeLeft.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 118 */     this.EyeLeft.setTextureSize(64, 32);
/* 119 */     this.EyeLeft.mirror = true;
/* 120 */     setRotation(this.EyeLeft, 0.0F, 0.0F, 0.0F);
/* 121 */     this.HeadMid = new ModelRenderer(this, 0, 0);
/* 122 */     this.HeadMid.addBox(-2.5F, -1.5F, -5.0F, 5, 3, 2);
/* 123 */     this.HeadMid.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 124 */     this.HeadMid.setTextureSize(64, 32);
/* 125 */     this.HeadMid.mirror = true;
/* 126 */     setRotation(this.HeadMid, 0.0F, 0.0F, 0.0F);
/* 127 */     this.HeadEnd = new ModelRenderer(this, 0, 0);
/* 128 */     this.HeadEnd.addBox(-2.0F, -1.0F, -6.0F, 4, 2, 1);
/* 129 */     this.HeadEnd.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 130 */     this.HeadEnd.setTextureSize(64, 32);
/* 131 */     this.HeadEnd.mirror = true;
/* 132 */     setRotation(this.HeadEnd, 0.0F, 0.0F, 0.0F);
/* 133 */     this.TailTuft = new ModelRenderer(this, 0, 23);
/* 134 */     this.TailTuft.addBox(-2.0F, -1.0F, 3.0F, 4, 1, 2);
/* 135 */     this.TailTuft.setRotationPoint(0.0F, 19.0F, 10.0F);
/* 136 */     this.TailTuft.setTextureSize(64, 32);
/* 137 */     this.TailTuft.mirror = true;
/* 138 */     setRotation(this.TailTuft, 0.0F, 0.0F, 0.0F);
/* 139 */     this.EyeRight = new ModelRenderer(this, 0, 28);
/* 140 */     this.EyeRight.addBox(-3.5F, -2.5F, -2.5F, 3, 2, 2);
/* 141 */     this.EyeRight.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 142 */     this.EyeRight.setTextureSize(64, 32);
/* 143 */     this.EyeRight.mirror = true;
/* 144 */     setRotation(this.EyeRight, 0.0F, 0.0F, 0.0F);
/* 145 */     this.BodyTopLeft4 = new ModelRenderer(this, 0, 0);
/* 146 */     this.BodyTopLeft4.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4);
/* 147 */     this.BodyTopLeft4.setRotationPoint(0.0F, 16.2F, 7.0F);
/* 148 */     this.BodyTopLeft4.setTextureSize(64, 32);
/* 149 */     this.BodyTopLeft4.mirror = true;
/* 150 */     setRotation(this.BodyTopLeft4, 0.1047198F, 0.1047198F, 0.1047198F);
/* 151 */     this.BodyTopRight4 = new ModelRenderer(this, 0, 0);
/* 152 */     this.BodyTopRight4.addBox(-5.0F, 0.0F, 0.0F, 6, 3, 4);
/* 153 */     this.BodyTopRight4.setRotationPoint(-1.0F, 16.2F, 7.0F);
/* 154 */     this.BodyTopRight4.setTextureSize(64, 32);
/* 155 */     this.BodyTopRight4.mirror = true;
/* 156 */     setRotation(this.BodyTopRight4, 0.1047198F, -0.1047198F, -0.1047198F);
/* 157 */     this.BodyTopLeft1 = new ModelRenderer(this, 0, 0);
/* 158 */     this.BodyTopLeft1.addBox(0.0F, 0.0F, 0.0F, 5, 3, 4);
/* 159 */     this.BodyTopLeft1.setRotationPoint(0.0F, 16.0F, -4.0F);
/* 160 */     this.BodyTopLeft1.setTextureSize(64, 32);
/* 161 */     this.BodyTopLeft1.mirror = true;
/* 162 */     setRotation(this.BodyTopLeft1, 0.1745329F, 0.1745329F, 0.1047198F);
/* 163 */     this.BodyTopRight1 = new ModelRenderer(this, 0, 0);
/* 164 */     this.BodyTopRight1.addBox(-5.0F, 0.0F, 0.0F, 5, 3, 4);
/* 165 */     this.BodyTopRight1.setRotationPoint(0.0F, 16.0F, -4.0F);
/* 166 */     this.BodyTopRight1.setTextureSize(64, 32);
/* 167 */     this.BodyTopRight1.mirror = true;
/* 168 */     setRotation(this.BodyTopRight1, 0.1745329F, -0.1745329F, -0.1047198F);
/* 169 */     this.BodyTopRight2 = new ModelRenderer(this, 0, 0);
/* 170 */     this.BodyTopRight2.addBox(-5.0F, 0.0F, 0.0F, 7, 3, 4);
/* 171 */     this.BodyTopRight2.setRotationPoint(-1.0F, 16.0F, -1.0F);
/* 172 */     this.BodyTopRight2.setTextureSize(64, 32);
/* 173 */     this.BodyTopRight2.mirror = true;
/* 174 */     setRotation(this.BodyTopRight2, 0.2094395F, -0.1745329F, -0.1047198F);
/* 175 */     this.BodyTopLeft2 = new ModelRenderer(this, 0, 0);
/* 176 */     this.BodyTopLeft2.addBox(-1.0F, 0.0F, 0.0F, 7, 3, 4);
/* 177 */     this.BodyTopLeft2.setRotationPoint(0.0F, 16.0F, -1.0F);
/* 178 */     this.BodyTopLeft2.setTextureSize(64, 32);
/* 179 */     this.BodyTopLeft2.mirror = true;
/* 180 */     setRotation(this.BodyTopLeft2, 0.2094395F, 0.1745329F, 0.1047198F);
/* 181 */     this.BodyTopRight3 = new ModelRenderer(this, 0, 0);
/* 182 */     this.BodyTopRight3.addBox(-5.0F, 0.0F, 0.0F, 6, 3, 4);
/* 183 */     this.BodyTopRight3.setRotationPoint(-1.0F, 16.0F, 3.0F);
/* 184 */     this.BodyTopRight3.setTextureSize(64, 32);
/* 185 */     this.BodyTopRight3.mirror = true;
/* 186 */     setRotation(this.BodyTopRight3, 0.1396263F, -0.1396263F, -0.1047198F);
/* 187 */     this.BodyTopLeft3 = new ModelRenderer(this, 0, 0);
/* 188 */     this.BodyTopLeft3.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4);
/* 189 */     this.BodyTopLeft3.setRotationPoint(0.0F, 16.0F, 3.0F);
/* 190 */     this.BodyTopLeft3.setTextureSize(64, 32);
/* 191 */     this.BodyTopLeft3.mirror = true;
/* 192 */     setRotation(this.BodyTopLeft3, 0.1396263F, 0.1396263F, 0.1047198F);
/* 193 */     this.HeadBase = new ModelRenderer(this, 0, 0);
/* 194 */     this.HeadBase.addBox(-3.0F, -2.0F, -3.0F, 6, 4, 3);
/* 195 */     this.HeadBase.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 196 */     this.HeadBase.setTextureSize(64, 32);
/* 197 */     this.HeadBase.mirror = true;
/* 198 */     setRotation(this.HeadBase, 0.0F, 0.0F, 0.0F);
/* 199 */     this.TailBase = new ModelRenderer(this, 0, 0);
/* 200 */     this.TailBase.addBox(-3.0F, -2.0F, 0.0F, 6, 3, 3);
/* 201 */     this.TailBase.setRotationPoint(0.0F, 19.0F, 10.0F);
/* 202 */     this.TailBase.setTextureSize(64, 32);
/* 203 */     this.TailBase.mirror = true;
/* 204 */     setRotation(this.TailBase, 0.0F, 0.0F, 0.0F);
/* 205 */     this.BodyLow2 = new ModelRenderer(this, 34, 0);
/* 206 */     this.BodyLow2.addBox(0.0F, 0.0F, 0.0F, 8, 2, 7);
/* 207 */     this.BodyLow2.setRotationPoint(-4.0F, 18.3F, 3.0F);
/* 208 */     this.BodyLow2.setTextureSize(64, 32);
/* 209 */     this.BodyLow2.mirror = true;
/* 210 */     setRotation(this.BodyLow2, 0.0F, 0.0F, 0.0F);
/* 211 */     this.BodyLow1 = new ModelRenderer(this, 34, 0);
/* 212 */     this.BodyLow1.addBox(0.0F, 0.0F, 0.0F, 8, 2, 7);
/* 213 */     this.BodyLow1.setRotationPoint(-4.0F, 18.7F, -4.0F);
/* 214 */     this.BodyLow1.setTextureSize(64, 32);
/* 215 */     this.BodyLow1.mirror = true;
/* 216 */     setRotation(this.BodyLow1, 0.0F, 0.0F, 0.0F);
/* 217 */     this.Spine5 = new ModelRenderer(this, 0, 0);
/* 218 */     this.Spine5.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 219 */     this.Spine5.setRotationPoint(0.0F, 16.0F, 8.6F);
/* 220 */     this.Spine5.setTextureSize(64, 32);
/* 221 */     this.Spine5.mirror = true;
/* 222 */     setRotation(this.Spine5, 0.0F, 0.0F, 0.0F);
/* 223 */     this.Spine1 = new ModelRenderer(this, 0, 0);
/* 224 */     this.Spine1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 225 */     this.Spine1.setRotationPoint(0.0F, 16.0F, -4.2F);
/* 226 */     this.Spine1.setTextureSize(64, 32);
/* 227 */     this.Spine1.mirror = true;
/* 228 */     setRotation(this.Spine1, 0.2443461F, 0.0F, 0.0F);
/* 229 */     this.Spine2 = new ModelRenderer(this, 0, 0);
/* 230 */     this.Spine2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5);
/* 231 */     this.Spine2.setRotationPoint(0.0F, 16.0F, -1.2F);
/* 232 */     this.Spine2.setTextureSize(64, 32);
/* 233 */     this.Spine2.mirror = true;
/* 234 */     setRotation(this.Spine2, 0.3141593F, 0.0F, 0.0F);
/* 235 */     this.Spine3 = new ModelRenderer(this, 0, 0);
/* 236 */     this.Spine3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 6);
/* 237 */     this.Spine3.setRotationPoint(0.0F, 16.0F, 1.8F);
/* 238 */     this.Spine3.setTextureSize(64, 32);
/* 239 */     this.Spine3.mirror = true;
/* 240 */     setRotation(this.Spine3, 0.2792527F, 0.0F, 0.0F);
/* 241 */     this.Spine4 = new ModelRenderer(this, 0, 0);
/* 242 */     this.Spine4.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 8);
/* 243 */     this.Spine4.setRotationPoint(0.0F, 16.0F, 3.8F);
/* 244 */     this.Spine4.setTextureSize(64, 32);
/* 245 */     this.Spine4.mirror = true;
/* 246 */     setRotation(this.Spine4, 0.1745329F, 0.0F, 0.0F);
/* 247 */     this.RightArmSeg4 = new ModelRenderer(this, 0, 0);
/* 248 */     this.RightArmSeg4.addBox(-3.2F, -1.0F, -10.5F, 2, 2, 4);
/* 249 */     this.RightArmSeg4.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 250 */     this.RightArmSeg4.setTextureSize(64, 32);
/* 251 */     this.RightArmSeg4.mirror = true;
/* 252 */     setRotation(this.RightArmSeg4, 0.0F, 0.0872665F, 0.0F);
/* 253 */     this.LeftArmSeg1 = new ModelRenderer(this, 0, 13);
/* 254 */     this.LeftArmSeg1.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4);
/* 255 */     this.LeftArmSeg1.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 256 */     this.LeftArmSeg1.setTextureSize(64, 32);
/* 257 */     this.LeftArmSeg1.mirror = true;
/* 258 */     setRotation(this.LeftArmSeg1, 0.0F, -0.5235988F, 0.0F);
/* 259 */     this.LeftArmSeg3 = new ModelRenderer(this, 0, 13);
/* 260 */     this.LeftArmSeg3.addBox(1.0F, -0.5F, -8.0F, 1, 1, 3);
/* 261 */     this.LeftArmSeg3.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 262 */     this.LeftArmSeg3.setTextureSize(64, 32);
/* 263 */     this.LeftArmSeg3.mirror = true;
/* 264 */     setRotation(this.LeftArmSeg3, 0.0F, -0.1745329F, 0.0F);
/* 265 */     this.RightArmSeg2 = new ModelRenderer(this, 0, 0);
/* 266 */     this.RightArmSeg2.addBox(-1.5F, -1.0F, -6.0F, 2, 2, 4);
/* 267 */     this.RightArmSeg2.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 268 */     this.RightArmSeg2.setTextureSize(64, 32);
/* 269 */     this.RightArmSeg2.mirror = true;
/* 270 */     setRotation(this.RightArmSeg2, 0.0F, 0.3490659F, 0.0F);
/* 271 */     this.RightArmSeg1 = new ModelRenderer(this, 0, 13);
/* 272 */     this.RightArmSeg1.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4);
/* 273 */     this.RightArmSeg1.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 274 */     this.RightArmSeg1.setTextureSize(64, 32);
/* 275 */     this.RightArmSeg1.mirror = true;
/* 276 */     setRotation(this.RightArmSeg1, 0.0F, 0.5235988F, 0.0F);
/* 277 */     this.LeftArmSeg5 = new ModelRenderer(this, 0, 13);
/* 278 */     this.LeftArmSeg5.addBox(2.4F, -0.5F, -12.0F, 1, 1, 3);
/* 279 */     this.LeftArmSeg5.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 280 */     this.LeftArmSeg5.setTextureSize(64, 32);
/* 281 */     this.LeftArmSeg5.mirror = true;
/* 282 */     setRotation(this.LeftArmSeg5, 0.0F, 0.0F, 0.0F);
/* 283 */     this.LeftArmSeg2 = new ModelRenderer(this, 0, 0);
/* 284 */     this.LeftArmSeg2.addBox(-0.5F, -1.0F, -6.0F, 2, 2, 4);
/* 285 */     this.LeftArmSeg2.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 286 */     this.LeftArmSeg2.setTextureSize(64, 32);
/* 287 */     this.LeftArmSeg2.mirror = true;
/* 288 */     setRotation(this.LeftArmSeg2, 0.0F, -0.3490659F, 0.0F);
/* 289 */     this.LeftClawTop = new ModelRenderer(this, 15, 15);
/* 290 */     this.LeftClawTop.addBox(1.8F, 4.7F, -15.0F, 2, 2, 5);
/* 291 */     this.LeftClawTop.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 292 */     this.LeftClawTop.setTextureSize(64, 32);
/* 293 */     this.LeftClawTop.mirror = true;
/* 294 */     setRotation(this.LeftClawTop, -0.5410521F, 0.0F, 0.0F);
/* 295 */     this.RightArmSeg3 = new ModelRenderer(this, 0, 13);
/* 296 */     this.RightArmSeg3.addBox(-2.0F, -0.5F, -8.0F, 1, 1, 3);
/* 297 */     this.RightArmSeg3.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 298 */     this.RightArmSeg3.setTextureSize(64, 32);
/* 299 */     this.RightArmSeg3.mirror = true;
/* 300 */     setRotation(this.RightArmSeg3, 0.0F, 0.1745329F, 0.0F);
/* 301 */     this.RightArmSeg5 = new ModelRenderer(this, 0, 13);
/* 302 */     this.RightArmSeg5.addBox(-3.6F, -0.5F, -12.0F, 1, 1, 3);
/* 303 */     this.RightArmSeg5.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 304 */     this.RightArmSeg5.setTextureSize(64, 32);
/* 305 */     this.RightArmSeg5.mirror = true;
/* 306 */     setRotation(this.RightArmSeg5, 0.0F, 0.0F, 0.0F);
/* 307 */     this.LeftArmSeg4 = new ModelRenderer(this, 0, 0);
/* 308 */     this.LeftArmSeg4.addBox(1.1F, -1.0F, -10.5F, 2, 2, 4);
/* 309 */     this.LeftArmSeg4.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 310 */     this.LeftArmSeg4.setTextureSize(64, 32);
/* 311 */     this.LeftArmSeg4.mirror = true;
/* 312 */     setRotation(this.LeftArmSeg4, 0.0F, -0.0872665F, 0.0F);
/* 313 */     this.LeftClawBase = new ModelRenderer(this, 0, 0);
/* 314 */     this.LeftClawBase.addBox(1.8F, -1.0F, -13.0F, 2, 2, 2);
/* 315 */     this.LeftClawBase.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 316 */     this.LeftClawBase.setTextureSize(64, 32);
/* 317 */     this.LeftClawBase.mirror = true;
/* 318 */     setRotation(this.LeftClawBase, 0.0F, 0.0F, 0.0F);
/* 319 */     this.RightClawBase = new ModelRenderer(this, 0, 0);
/* 320 */     this.RightClawBase.addBox(-4.2F, -1.0F, -13.0F, 2, 2, 2);
/* 321 */     this.RightClawBase.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 322 */     this.RightClawBase.setTextureSize(64, 32);
/* 323 */     this.RightClawBase.mirror = true;
/* 324 */     setRotation(this.RightClawBase, 0.0F, 0.0F, 0.0F);
/* 325 */     this.LeftClawLow = new ModelRenderer(this, 25, 25);
/* 326 */     this.LeftClawLow.addBox(1.8F, -4.3F, -15.0F, 2, 1, 4);
/* 327 */     this.LeftClawLow.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 328 */     this.LeftClawLow.setTextureSize(64, 32);
/* 329 */     this.LeftClawLow.mirror = true;
/* 330 */     setRotation(this.LeftClawLow, 0.3490659F, 0.0F, 0.0F);
/* 331 */     this.RightClawTop = new ModelRenderer(this, 15, 15);
/* 332 */     this.RightClawTop.addBox(-4.2F, 4.7F, -15.0F, 2, 2, 5);
/* 333 */     this.RightClawTop.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 334 */     this.RightClawTop.setTextureSize(64, 32);
/* 335 */     this.RightClawTop.mirror = true;
/* 336 */     setRotation(this.RightClawTop, -0.5410521F, 0.0F, 0.0F);
/* 337 */     this.RightClawLow = new ModelRenderer(this, 25, 25);
/* 338 */     this.RightClawLow.addBox(-4.2F, -4.3F, -15.0F, 2, 1, 4);
/* 339 */     this.RightClawLow.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 340 */     this.RightClawLow.setTextureSize(64, 32);
/* 341 */     this.RightClawLow.mirror = true;
/* 342 */     setRotation(this.RightClawLow, 0.3490659F, 0.0F, 0.0F);
/* 343 */     this.LBLeg1 = new ModelRenderer(this, 0, 13);
/* 344 */     this.LBLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 345 */     this.LBLeg1.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 346 */     this.LBLeg1.setTextureSize(64, 32);
/* 347 */     this.LBLeg1.mirror = true;
/* 348 */     setRotation(this.LBLeg1, 0.0F, 0.0F, -0.4363323F);
/* 349 */     this.LBLeg3 = new ModelRenderer(this, 2, 0);
/* 350 */     this.LBLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 351 */     this.LBLeg3.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 352 */     this.LBLeg3.setTextureSize(64, 32);
/* 353 */     this.LBLeg3.mirror = true;
/* 354 */     setRotation(this.LBLeg3, 0.0F, 0.0F, -0.5759587F);
/* 355 */     this.RBLeg1 = new ModelRenderer(this, 0, 13);
/* 356 */     this.RBLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 357 */     this.RBLeg1.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 358 */     this.RBLeg1.setTextureSize(64, 32);
/* 359 */     this.RBLeg1.mirror = true;
/* 360 */     setRotation(this.RBLeg1, 0.0F, 0.0F, 0.4363323F);
/* 361 */     this.RBLeg3 = new ModelRenderer(this, 2, 0);
/* 362 */     this.RBLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 363 */     this.RBLeg3.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 364 */     this.RBLeg3.setTextureSize(64, 32);
/* 365 */     this.RBLeg3.mirror = true;
/* 366 */     setRotation(this.RBLeg3, 0.0F, 0.0F, 0.5759587F);
/* 367 */     this.LBLeg2 = new ModelRenderer(this, 0, 0);
/* 368 */     this.LBLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 369 */     this.LBLeg2.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 370 */     this.LBLeg2.setTextureSize(64, 32);
/* 371 */     this.LBLeg2.mirror = true;
/* 372 */     setRotation(this.LBLeg2, 0.0F, 0.0F, -0.9599311F);
/* 373 */     this.RBLeg2 = new ModelRenderer(this, 0, 0);
/* 374 */     this.RBLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 375 */     this.RBLeg2.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 376 */     this.RBLeg2.setTextureSize(64, 32);
/* 377 */     this.RBLeg2.mirror = true;
/* 378 */     setRotation(this.RBLeg2, 0.0F, 0.0F, 0.9599311F);
/* 379 */     this.LBLeg4 = new ModelRenderer(this, 0, 13);
/* 380 */     this.LBLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 381 */     this.LBLeg4.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 382 */     this.LBLeg4.setTextureSize(64, 32);
/* 383 */     this.LBLeg4.mirror = true;
/* 384 */     setRotation(this.LBLeg4, 0.0F, 0.0F, -0.2094395F);
/* 385 */     this.RBLeg4 = new ModelRenderer(this, 0, 13);
/* 386 */     this.RBLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 387 */     this.RBLeg4.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 388 */     this.RBLeg4.setTextureSize(64, 32);
/* 389 */     this.RBLeg4.mirror = true;
/* 390 */     setRotation(this.RBLeg4, 0.0F, 0.0F, 0.2094395F);
/* 391 */     this.RBLeg5 = new ModelRenderer(this, 0, 0);
/* 392 */     this.RBLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 393 */     this.RBLeg5.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 394 */     this.RBLeg5.setTextureSize(64, 32);
/* 395 */     this.RBLeg5.mirror = true;
/* 396 */     setRotation(this.RBLeg5, 0.0F, 0.0F, 0.1047198F);
/* 397 */     this.LBLeg6 = new ModelRenderer(this, 0, 13);
/* 398 */     this.LBLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 399 */     this.LBLeg6.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 400 */     this.LBLeg6.setTextureSize(64, 32);
/* 401 */     this.LBLeg6.mirror = true;
/* 402 */     setRotation(this.LBLeg6, 0.0F, 0.0F, 0.0F);
/* 403 */     this.RBLeg6 = new ModelRenderer(this, 0, 13);
/* 404 */     this.RBLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 405 */     this.RBLeg6.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 406 */     this.RBLeg6.setTextureSize(64, 32);
/* 407 */     this.RBLeg6.mirror = true;
/* 408 */     setRotation(this.RBLeg6, 0.0F, 0.0F, 0.0F);
/* 409 */     this.LBLeg5 = new ModelRenderer(this, 0, 0);
/* 410 */     this.LBLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 411 */     this.LBLeg5.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 412 */     this.LBLeg5.setTextureSize(64, 32);
/* 413 */     this.LBLeg5.mirror = true;
/* 414 */     setRotation(this.LBLeg5, 0.0F, 0.0F, -0.1047198F);
/* 415 */     this.RFLeg1 = new ModelRenderer(this, 0, 13);
/* 416 */     this.RFLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 417 */     this.RFLeg1.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 418 */     this.RFLeg1.setTextureSize(64, 32);
/* 419 */     this.RFLeg1.mirror = true;
/* 420 */     setRotation(this.RFLeg1, 0.0F, 0.0F, 0.4363323F);
/* 421 */     this.RFLeg2 = new ModelRenderer(this, 0, 0);
/* 422 */     this.RFLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 423 */     this.RFLeg2.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 424 */     this.RFLeg2.setTextureSize(64, 32);
/* 425 */     this.RFLeg2.mirror = true;
/* 426 */     setRotation(this.RFLeg2, 0.0F, 0.0F, 0.9599311F);
/* 427 */     this.RFLeg3 = new ModelRenderer(this, 2, 0);
/* 428 */     this.RFLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 429 */     this.RFLeg3.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 430 */     this.RFLeg3.setTextureSize(64, 32);
/* 431 */     this.RFLeg3.mirror = true;
/* 432 */     setRotation(this.RFLeg3, 0.0F, 0.0F, 0.5759587F);
/* 433 */     this.RFLeg4 = new ModelRenderer(this, 0, 13);
/* 434 */     this.RFLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 435 */     this.RFLeg4.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 436 */     this.RFLeg4.setTextureSize(64, 32);
/* 437 */     this.RFLeg4.mirror = true;
/* 438 */     setRotation(this.RFLeg4, 0.0F, 0.0F, 0.2094395F);
/* 439 */     this.RFLeg5 = new ModelRenderer(this, 0, 0);
/* 440 */     this.RFLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 441 */     this.RFLeg5.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 442 */     this.RFLeg5.setTextureSize(64, 32);
/* 443 */     this.RFLeg5.mirror = true;
/* 444 */     setRotation(this.RFLeg5, 0.0F, 0.0F, 0.1047198F);
/* 445 */     this.RFLeg6 = new ModelRenderer(this, 0, 13);
/* 446 */     this.RFLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 447 */     this.RFLeg6.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 448 */     this.RFLeg6.setTextureSize(64, 32);
/* 449 */     this.RFLeg6.mirror = true;
/* 450 */     setRotation(this.RFLeg6, 0.0F, 0.0F, 0.0F);
/* 451 */     this.RMLeg1 = new ModelRenderer(this, 0, 13);
/* 452 */     this.RMLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 453 */     this.RMLeg1.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 454 */     this.RMLeg1.setTextureSize(64, 32);
/* 455 */     this.RMLeg1.mirror = true;
/* 456 */     setRotation(this.RMLeg1, 0.0F, 0.0F, 0.4363323F);
/* 457 */     this.RMLeg2 = new ModelRenderer(this, 0, 0);
/* 458 */     this.RMLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 459 */     this.RMLeg2.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 460 */     this.RMLeg2.setTextureSize(64, 32);
/* 461 */     this.RMLeg2.mirror = true;
/* 462 */     setRotation(this.RMLeg2, 0.0F, 0.0F, 0.9599311F);
/* 463 */     this.RMLeg3 = new ModelRenderer(this, 2, 0);
/* 464 */     this.RMLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 465 */     this.RMLeg3.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 466 */     this.RMLeg3.setTextureSize(64, 32);
/* 467 */     this.RMLeg3.mirror = true;
/* 468 */     setRotation(this.RMLeg3, 0.0F, 0.0F, 0.5759587F);
/* 469 */     this.RMLeg4 = new ModelRenderer(this, 0, 13);
/* 470 */     this.RMLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 471 */     this.RMLeg4.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 472 */     this.RMLeg4.setTextureSize(64, 32);
/* 473 */     this.RMLeg4.mirror = true;
/* 474 */     setRotation(this.RMLeg4, 0.0F, 0.0F, 0.2094395F);
/* 475 */     this.RMLeg5 = new ModelRenderer(this, 0, 0);
/* 476 */     this.RMLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 477 */     this.RMLeg5.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 478 */     this.RMLeg5.setTextureSize(64, 32);
/* 479 */     this.RMLeg5.mirror = true;
/* 480 */     setRotation(this.RMLeg5, 0.0F, 0.0F, 0.1047198F);
/* 481 */     this.RMLeg6 = new ModelRenderer(this, 0, 13);
/* 482 */     this.RMLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 483 */     this.RMLeg6.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 484 */     this.RMLeg6.setTextureSize(64, 32);
/* 485 */     this.RMLeg6.mirror = true;
/* 486 */     setRotation(this.RMLeg6, 0.0F, 0.0F, 0.0F);
/* 487 */     this.LFLeg1 = new ModelRenderer(this, 0, 13);
/* 488 */     this.LFLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 489 */     this.LFLeg1.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 490 */     this.LFLeg1.setTextureSize(64, 32);
/* 491 */     this.LFLeg1.mirror = true;
/* 492 */     setRotation(this.LFLeg1, 0.0F, 0.0F, -0.4363323F);
/* 493 */     this.LFLeg2 = new ModelRenderer(this, 0, 0);
/* 494 */     this.LFLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 495 */     this.LFLeg2.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 496 */     this.LFLeg2.setTextureSize(64, 32);
/* 497 */     this.LFLeg2.mirror = true;
/* 498 */     setRotation(this.LFLeg2, 0.0F, 0.0F, -0.9599311F);
/* 499 */     this.LFLeg3 = new ModelRenderer(this, 2, 0);
/* 500 */     this.LFLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 501 */     this.LFLeg3.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 502 */     this.LFLeg3.setTextureSize(64, 32);
/* 503 */     this.LFLeg3.mirror = true;
/* 504 */     setRotation(this.LFLeg3, 0.0F, 0.0F, -0.5759587F);
/* 505 */     this.LFLeg4 = new ModelRenderer(this, 0, 13);
/* 506 */     this.LFLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 507 */     this.LFLeg4.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 508 */     this.LFLeg4.setTextureSize(64, 32);
/* 509 */     this.LFLeg4.mirror = true;
/* 510 */     setRotation(this.LFLeg4, 0.0F, 0.0F, -0.2094395F);
/* 511 */     this.LFLeg5 = new ModelRenderer(this, 0, 0);
/* 512 */     this.LFLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 513 */     this.LFLeg5.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 514 */     this.LFLeg5.setTextureSize(64, 32);
/* 515 */     this.LFLeg5.mirror = true;
/* 516 */     setRotation(this.LFLeg5, 0.0F, 0.0F, -0.1047198F);
/* 517 */     this.LFLeg6 = new ModelRenderer(this, 0, 13);
/* 518 */     this.LFLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 519 */     this.LFLeg6.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 520 */     this.LFLeg6.setTextureSize(64, 32);
/* 521 */     this.LFLeg6.mirror = true;
/* 522 */     setRotation(this.LFLeg6, 0.0F, 0.0F, 0.0F);
/* 523 */     this.LMLeg1 = new ModelRenderer(this, 0, 13);
/* 524 */     this.LMLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 525 */     this.LMLeg1.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 526 */     this.LMLeg1.setTextureSize(64, 32);
/* 527 */     this.LMLeg1.mirror = true;
/* 528 */     setRotation(this.LMLeg1, 0.0F, 0.0F, -0.4363323F);
/* 529 */     this.LMLeg2 = new ModelRenderer(this, 0, 0);
/* 530 */     this.LMLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 531 */     this.LMLeg2.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 532 */     this.LMLeg2.setTextureSize(64, 32);
/* 533 */     this.LMLeg2.mirror = true;
/* 534 */     setRotation(this.LMLeg2, 0.0F, 0.0F, -0.9599311F);
/* 535 */     this.LMLeg4 = new ModelRenderer(this, 0, 13);
/* 536 */     this.LMLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 537 */     this.LMLeg4.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 538 */     this.LMLeg4.setTextureSize(64, 32);
/* 539 */     this.LMLeg4.mirror = true;
/* 540 */     setRotation(this.LMLeg4, 0.0F, 0.0F, -0.2094395F);
/* 541 */     this.LMLeg3 = new ModelRenderer(this, 2, 0);
/* 542 */     this.LMLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 543 */     this.LMLeg3.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 544 */     this.LMLeg3.setTextureSize(64, 32);
/* 545 */     this.LMLeg3.mirror = true;
/* 546 */     setRotation(this.LMLeg3, 0.0F, 0.0F, -0.5759587F);
/* 547 */     this.LMLeg5 = new ModelRenderer(this, 0, 0);
/* 548 */     this.LMLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 549 */     this.LMLeg5.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 550 */     this.LMLeg5.setTextureSize(64, 32);
/* 551 */     this.LMLeg5.mirror = true;
/* 552 */     setRotation(this.LMLeg5, 0.0F, 0.0F, -0.1047198F);
/* 553 */     this.LMLeg6 = new ModelRenderer(this, 0, 13);
/* 554 */     this.LMLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 555 */     this.LMLeg6.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 556 */     this.LMLeg6.setTextureSize(64, 32);
/* 557 */     this.LMLeg6.mirror = true;
/* 558 */     setRotation(this.LMLeg6, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 564 */     CaveFisher e = (CaveFisher)entity;
/* 565 */     RenderInfo r = null;
/*     */     
/* 567 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 568 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 569 */     float newangle = 0.0F, upangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */     
/* 572 */     float pi4 = 1.570795F;
/*     */ 
/*     */     
/* 575 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/* 576 */     this.LFLeg1.rotateAngleY = newangle;
/* 577 */     this.LFLeg2.rotateAngleY = newangle;
/* 578 */     this.LFLeg3.rotateAngleY = newangle;
/* 579 */     this.LFLeg4.rotateAngleY = newangle;
/* 580 */     this.LFLeg5.rotateAngleY = newangle;
/* 581 */     this.LFLeg6.rotateAngleY = newangle;
/* 582 */     this.RFLeg1.rotateAngleY = -newangle;
/* 583 */     this.RFLeg2.rotateAngleY = -newangle;
/* 584 */     this.RFLeg3.rotateAngleY = -newangle;
/* 585 */     this.RFLeg4.rotateAngleY = -newangle;
/* 586 */     this.RFLeg5.rotateAngleY = -newangle;
/* 587 */     this.RFLeg6.rotateAngleY = -newangle;
/*     */     
/* 589 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 1.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 590 */     this.LMLeg1.rotateAngleY = newangle;
/* 591 */     this.LMLeg2.rotateAngleY = newangle;
/* 592 */     this.LMLeg3.rotateAngleY = newangle;
/* 593 */     this.LMLeg4.rotateAngleY = newangle;
/* 594 */     this.LMLeg5.rotateAngleY = newangle;
/* 595 */     this.LMLeg6.rotateAngleY = newangle;
/* 596 */     this.RMLeg1.rotateAngleY = -newangle;
/* 597 */     this.RMLeg2.rotateAngleY = -newangle;
/* 598 */     this.RMLeg3.rotateAngleY = -newangle;
/* 599 */     this.RMLeg4.rotateAngleY = -newangle;
/* 600 */     this.RMLeg5.rotateAngleY = -newangle;
/* 601 */     this.RMLeg6.rotateAngleY = -newangle;
/*     */     
/* 603 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 604 */     this.LBLeg1.rotateAngleY = newangle;
/* 605 */     this.LBLeg2.rotateAngleY = newangle;
/* 606 */     this.LBLeg3.rotateAngleY = newangle;
/* 607 */     this.LBLeg4.rotateAngleY = newangle;
/* 608 */     this.LBLeg5.rotateAngleY = newangle;
/* 609 */     this.LBLeg6.rotateAngleY = newangle;
/* 610 */     this.RBLeg1.rotateAngleY = -newangle;
/* 611 */     this.RBLeg2.rotateAngleY = -newangle;
/* 612 */     this.RBLeg3.rotateAngleY = -newangle;
/* 613 */     this.RBLeg4.rotateAngleY = -newangle;
/* 614 */     this.RBLeg5.rotateAngleY = -newangle;
/* 615 */     this.RBLeg6.rotateAngleY = -newangle;
/*     */ 
/*     */ 
/*     */     
/* 619 */     r = e.getRenderInfo();
/*     */ 
/*     */     
/* 622 */     newangle = MathHelper.cos(f2 * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 623 */     nextangle = MathHelper.cos((f2 + 0.1F) * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */     
/* 625 */     if (e.getAttacking() == 0) {
/* 626 */       newangle = 0.0F;
/*     */     }
/* 628 */     if (nextangle > 0.0F && newangle < 0.0F) {
/*     */ 
/*     */       
/* 631 */       r.ri1 = 0;
/*     */       
/* 633 */       if (e.getAttacking() == 0) {
/* 634 */         r.ri1 = e.world.rand.nextInt(20);
/* 635 */         r.ri2 = e.world.rand.nextInt(25);
/*     */       } else {
/* 637 */         r.ri1 = e.world.rand.nextInt(4);
/* 638 */         r.ri2 = e.world.rand.nextInt(3);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 643 */     if (r.ri1 == 1 || r.ri1 == 3) {
/* 644 */       doLeftClaw(newangle);
/* 645 */       doRightClaw(newangle);
/*     */     } else {
/* 647 */       doLeftClaw(0.0F);
/* 648 */       doRightClaw(0.0F);
/*     */     } 
/*     */ 
/*     */     
/* 652 */     e.setRenderInfo(r);
/*     */     
/* 654 */     this.Nose.render(f5);
/* 655 */     this.EyeLeft.render(f5);
/* 656 */     this.HeadMid.render(f5);
/* 657 */     this.HeadEnd.render(f5);
/* 658 */     this.TailTuft.render(f5);
/* 659 */     this.EyeRight.render(f5);
/* 660 */     this.BodyTopLeft4.render(f5);
/* 661 */     this.BodyTopRight4.render(f5);
/* 662 */     this.BodyTopLeft1.render(f5);
/* 663 */     this.BodyTopRight1.render(f5);
/* 664 */     this.BodyTopRight2.render(f5);
/* 665 */     this.BodyTopLeft2.render(f5);
/* 666 */     this.BodyTopRight3.render(f5);
/* 667 */     this.BodyTopLeft3.render(f5);
/* 668 */     this.HeadBase.render(f5);
/* 669 */     this.TailBase.render(f5);
/* 670 */     this.BodyLow2.render(f5);
/* 671 */     this.BodyLow1.render(f5);
/* 672 */     this.Spine5.render(f5);
/* 673 */     this.Spine1.render(f5);
/* 674 */     this.Spine2.render(f5);
/* 675 */     this.Spine3.render(f5);
/* 676 */     this.Spine4.render(f5);
/* 677 */     this.RightArmSeg4.render(f5);
/* 678 */     this.LeftArmSeg1.render(f5);
/* 679 */     this.LeftArmSeg3.render(f5);
/* 680 */     this.RightArmSeg2.render(f5);
/* 681 */     this.RightArmSeg1.render(f5);
/* 682 */     this.LeftArmSeg5.render(f5);
/* 683 */     this.LeftArmSeg2.render(f5);
/* 684 */     this.LeftClawTop.render(f5);
/* 685 */     this.RightArmSeg3.render(f5);
/* 686 */     this.RightArmSeg5.render(f5);
/* 687 */     this.LeftArmSeg4.render(f5);
/* 688 */     this.LeftClawBase.render(f5);
/* 689 */     this.RightClawBase.render(f5);
/* 690 */     this.LeftClawLow.render(f5);
/* 691 */     this.RightClawTop.render(f5);
/* 692 */     this.RightClawLow.render(f5);
/* 693 */     this.LBLeg1.render(f5);
/* 694 */     this.LBLeg3.render(f5);
/* 695 */     this.RBLeg1.render(f5);
/* 696 */     this.RBLeg3.render(f5);
/* 697 */     this.LBLeg2.render(f5);
/* 698 */     this.RBLeg2.render(f5);
/* 699 */     this.LBLeg4.render(f5);
/* 700 */     this.RBLeg4.render(f5);
/* 701 */     this.RBLeg5.render(f5);
/* 702 */     this.LBLeg6.render(f5);
/* 703 */     this.RBLeg6.render(f5);
/* 704 */     this.LBLeg5.render(f5);
/* 705 */     this.RFLeg1.render(f5);
/* 706 */     this.RFLeg2.render(f5);
/* 707 */     this.RFLeg3.render(f5);
/* 708 */     this.RFLeg4.render(f5);
/* 709 */     this.RFLeg5.render(f5);
/* 710 */     this.RFLeg6.render(f5);
/* 711 */     this.RMLeg1.render(f5);
/* 712 */     this.RMLeg2.render(f5);
/* 713 */     this.RMLeg3.render(f5);
/* 714 */     this.RMLeg4.render(f5);
/* 715 */     this.RMLeg5.render(f5);
/* 716 */     this.RMLeg6.render(f5);
/* 717 */     this.LFLeg1.render(f5);
/* 718 */     this.LFLeg2.render(f5);
/* 719 */     this.LFLeg3.render(f5);
/* 720 */     this.LFLeg4.render(f5);
/* 721 */     this.LFLeg5.render(f5);
/* 722 */     this.LFLeg6.render(f5);
/* 723 */     this.LMLeg1.render(f5);
/* 724 */     this.LMLeg2.render(f5);
/* 725 */     this.LMLeg4.render(f5);
/* 726 */     this.LMLeg3.render(f5);
/* 727 */     this.LMLeg5.render(f5);
/* 728 */     this.LMLeg6.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 733 */     model.rotateAngleX = x;
/* 734 */     model.rotateAngleY = y;
/* 735 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 740 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 745 */     this.LeftArmSeg1.rotateAngleX = Math.abs(angle);
/* 746 */     this.LeftArmSeg2.rotateAngleX = Math.abs(angle);
/* 747 */     this.LeftArmSeg3.rotateAngleX = Math.abs(angle);
/* 748 */     this.LeftArmSeg4.rotateAngleX = Math.abs(angle);
/* 749 */     this.LeftArmSeg5.rotateAngleX = Math.abs(angle);
/* 750 */     this.LeftClawBase.rotateAngleX = Math.abs(angle);
/* 751 */     this.LeftClawTop.rotateAngleX = Math.abs(angle) - 0.54F;
/* 752 */     this.LeftClawLow.rotateAngleX = Math.abs(angle) + 0.35F;
/*     */   }
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 756 */     this.RightArmSeg1.rotateAngleX = Math.abs(angle);
/* 757 */     this.RightArmSeg2.rotateAngleX = Math.abs(angle);
/* 758 */     this.RightArmSeg3.rotateAngleX = Math.abs(angle);
/* 759 */     this.RightArmSeg4.rotateAngleX = Math.abs(angle);
/* 760 */     this.RightArmSeg5.rotateAngleX = Math.abs(angle);
/* 761 */     this.RightClawBase.rotateAngleX = Math.abs(angle);
/* 762 */     this.RightClawTop.rotateAngleX = Math.abs(angle) - 0.54F;
/* 763 */     this.RightClawLow.rotateAngleX = Math.abs(angle) + 0.35F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelCaveFisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */