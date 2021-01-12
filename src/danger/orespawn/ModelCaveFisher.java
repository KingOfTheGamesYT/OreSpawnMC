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
/*     */ public class ModelCaveFisher
/*     */   extends ModelBase
/*     */ {
/*  23 */   private float wingspeed = 1.0F;
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
/* 103 */     this.wingspeed = f1;
/*     */     
/* 105 */     this.textureWidth = 64;
/* 106 */     this.textureHeight = 32;
/*     */     
/* 108 */     this.Nose = new ModelRenderer(this, 0, 0);
/* 109 */     this.Nose.addBox(-0.5F, -0.5F, -12.0F, 1, 1, 6);
/* 110 */     this.Nose.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 111 */     this.Nose.setTextureSize(64, 32);
/* 112 */     this.Nose.mirror = true;
/* 113 */     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
/* 114 */     this.EyeLeft = new ModelRenderer(this, 0, 28);
/* 115 */     this.EyeLeft.addBox(0.5F, -2.5F, -2.5F, 3, 2, 2);
/* 116 */     this.EyeLeft.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 117 */     this.EyeLeft.setTextureSize(64, 32);
/* 118 */     this.EyeLeft.mirror = true;
/* 119 */     setRotation(this.EyeLeft, 0.0F, 0.0F, 0.0F);
/* 120 */     this.HeadMid = new ModelRenderer(this, 0, 0);
/* 121 */     this.HeadMid.addBox(-2.5F, -1.5F, -5.0F, 5, 3, 2);
/* 122 */     this.HeadMid.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 123 */     this.HeadMid.setTextureSize(64, 32);
/* 124 */     this.HeadMid.mirror = true;
/* 125 */     setRotation(this.HeadMid, 0.0F, 0.0F, 0.0F);
/* 126 */     this.HeadEnd = new ModelRenderer(this, 0, 0);
/* 127 */     this.HeadEnd.addBox(-2.0F, -1.0F, -6.0F, 4, 2, 1);
/* 128 */     this.HeadEnd.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 129 */     this.HeadEnd.setTextureSize(64, 32);
/* 130 */     this.HeadEnd.mirror = true;
/* 131 */     setRotation(this.HeadEnd, 0.0F, 0.0F, 0.0F);
/* 132 */     this.TailTuft = new ModelRenderer(this, 0, 23);
/* 133 */     this.TailTuft.addBox(-2.0F, -1.0F, 3.0F, 4, 1, 2);
/* 134 */     this.TailTuft.setRotationPoint(0.0F, 19.0F, 10.0F);
/* 135 */     this.TailTuft.setTextureSize(64, 32);
/* 136 */     this.TailTuft.mirror = true;
/* 137 */     setRotation(this.TailTuft, 0.0F, 0.0F, 0.0F);
/* 138 */     this.EyeRight = new ModelRenderer(this, 0, 28);
/* 139 */     this.EyeRight.addBox(-3.5F, -2.5F, -2.5F, 3, 2, 2);
/* 140 */     this.EyeRight.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 141 */     this.EyeRight.setTextureSize(64, 32);
/* 142 */     this.EyeRight.mirror = true;
/* 143 */     setRotation(this.EyeRight, 0.0F, 0.0F, 0.0F);
/* 144 */     this.BodyTopLeft4 = new ModelRenderer(this, 0, 0);
/* 145 */     this.BodyTopLeft4.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4);
/* 146 */     this.BodyTopLeft4.setRotationPoint(0.0F, 16.2F, 7.0F);
/* 147 */     this.BodyTopLeft4.setTextureSize(64, 32);
/* 148 */     this.BodyTopLeft4.mirror = true;
/* 149 */     setRotation(this.BodyTopLeft4, 0.1047198F, 0.1047198F, 0.1047198F);
/* 150 */     this.BodyTopRight4 = new ModelRenderer(this, 0, 0);
/* 151 */     this.BodyTopRight4.addBox(-5.0F, 0.0F, 0.0F, 6, 3, 4);
/* 152 */     this.BodyTopRight4.setRotationPoint(-1.0F, 16.2F, 7.0F);
/* 153 */     this.BodyTopRight4.setTextureSize(64, 32);
/* 154 */     this.BodyTopRight4.mirror = true;
/* 155 */     setRotation(this.BodyTopRight4, 0.1047198F, -0.1047198F, -0.1047198F);
/* 156 */     this.BodyTopLeft1 = new ModelRenderer(this, 0, 0);
/* 157 */     this.BodyTopLeft1.addBox(0.0F, 0.0F, 0.0F, 5, 3, 4);
/* 158 */     this.BodyTopLeft1.setRotationPoint(0.0F, 16.0F, -4.0F);
/* 159 */     this.BodyTopLeft1.setTextureSize(64, 32);
/* 160 */     this.BodyTopLeft1.mirror = true;
/* 161 */     setRotation(this.BodyTopLeft1, 0.1745329F, 0.1745329F, 0.1047198F);
/* 162 */     this.BodyTopRight1 = new ModelRenderer(this, 0, 0);
/* 163 */     this.BodyTopRight1.addBox(-5.0F, 0.0F, 0.0F, 5, 3, 4);
/* 164 */     this.BodyTopRight1.setRotationPoint(0.0F, 16.0F, -4.0F);
/* 165 */     this.BodyTopRight1.setTextureSize(64, 32);
/* 166 */     this.BodyTopRight1.mirror = true;
/* 167 */     setRotation(this.BodyTopRight1, 0.1745329F, -0.1745329F, -0.1047198F);
/* 168 */     this.BodyTopRight2 = new ModelRenderer(this, 0, 0);
/* 169 */     this.BodyTopRight2.addBox(-5.0F, 0.0F, 0.0F, 7, 3, 4);
/* 170 */     this.BodyTopRight2.setRotationPoint(-1.0F, 16.0F, -1.0F);
/* 171 */     this.BodyTopRight2.setTextureSize(64, 32);
/* 172 */     this.BodyTopRight2.mirror = true;
/* 173 */     setRotation(this.BodyTopRight2, 0.2094395F, -0.1745329F, -0.1047198F);
/* 174 */     this.BodyTopLeft2 = new ModelRenderer(this, 0, 0);
/* 175 */     this.BodyTopLeft2.addBox(-1.0F, 0.0F, 0.0F, 7, 3, 4);
/* 176 */     this.BodyTopLeft2.setRotationPoint(0.0F, 16.0F, -1.0F);
/* 177 */     this.BodyTopLeft2.setTextureSize(64, 32);
/* 178 */     this.BodyTopLeft2.mirror = true;
/* 179 */     setRotation(this.BodyTopLeft2, 0.2094395F, 0.1745329F, 0.1047198F);
/* 180 */     this.BodyTopRight3 = new ModelRenderer(this, 0, 0);
/* 181 */     this.BodyTopRight3.addBox(-5.0F, 0.0F, 0.0F, 6, 3, 4);
/* 182 */     this.BodyTopRight3.setRotationPoint(-1.0F, 16.0F, 3.0F);
/* 183 */     this.BodyTopRight3.setTextureSize(64, 32);
/* 184 */     this.BodyTopRight3.mirror = true;
/* 185 */     setRotation(this.BodyTopRight3, 0.1396263F, -0.1396263F, -0.1047198F);
/* 186 */     this.BodyTopLeft3 = new ModelRenderer(this, 0, 0);
/* 187 */     this.BodyTopLeft3.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4);
/* 188 */     this.BodyTopLeft3.setRotationPoint(0.0F, 16.0F, 3.0F);
/* 189 */     this.BodyTopLeft3.setTextureSize(64, 32);
/* 190 */     this.BodyTopLeft3.mirror = true;
/* 191 */     setRotation(this.BodyTopLeft3, 0.1396263F, 0.1396263F, 0.1047198F);
/* 192 */     this.HeadBase = new ModelRenderer(this, 0, 0);
/* 193 */     this.HeadBase.addBox(-3.0F, -2.0F, -3.0F, 6, 4, 3);
/* 194 */     this.HeadBase.setRotationPoint(0.0F, 19.0F, -4.0F);
/* 195 */     this.HeadBase.setTextureSize(64, 32);
/* 196 */     this.HeadBase.mirror = true;
/* 197 */     setRotation(this.HeadBase, 0.0F, 0.0F, 0.0F);
/* 198 */     this.TailBase = new ModelRenderer(this, 0, 0);
/* 199 */     this.TailBase.addBox(-3.0F, -2.0F, 0.0F, 6, 3, 3);
/* 200 */     this.TailBase.setRotationPoint(0.0F, 19.0F, 10.0F);
/* 201 */     this.TailBase.setTextureSize(64, 32);
/* 202 */     this.TailBase.mirror = true;
/* 203 */     setRotation(this.TailBase, 0.0F, 0.0F, 0.0F);
/* 204 */     this.BodyLow2 = new ModelRenderer(this, 34, 0);
/* 205 */     this.BodyLow2.addBox(0.0F, 0.0F, 0.0F, 8, 2, 7);
/* 206 */     this.BodyLow2.setRotationPoint(-4.0F, 18.3F, 3.0F);
/* 207 */     this.BodyLow2.setTextureSize(64, 32);
/* 208 */     this.BodyLow2.mirror = true;
/* 209 */     setRotation(this.BodyLow2, 0.0F, 0.0F, 0.0F);
/* 210 */     this.BodyLow1 = new ModelRenderer(this, 34, 0);
/* 211 */     this.BodyLow1.addBox(0.0F, 0.0F, 0.0F, 8, 2, 7);
/* 212 */     this.BodyLow1.setRotationPoint(-4.0F, 18.7F, -4.0F);
/* 213 */     this.BodyLow1.setTextureSize(64, 32);
/* 214 */     this.BodyLow1.mirror = true;
/* 215 */     setRotation(this.BodyLow1, 0.0F, 0.0F, 0.0F);
/* 216 */     this.Spine5 = new ModelRenderer(this, 0, 0);
/* 217 */     this.Spine5.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 218 */     this.Spine5.setRotationPoint(0.0F, 16.0F, 8.6F);
/* 219 */     this.Spine5.setTextureSize(64, 32);
/* 220 */     this.Spine5.mirror = true;
/* 221 */     setRotation(this.Spine5, 0.0F, 0.0F, 0.0F);
/* 222 */     this.Spine1 = new ModelRenderer(this, 0, 0);
/* 223 */     this.Spine1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 224 */     this.Spine1.setRotationPoint(0.0F, 16.0F, -4.2F);
/* 225 */     this.Spine1.setTextureSize(64, 32);
/* 226 */     this.Spine1.mirror = true;
/* 227 */     setRotation(this.Spine1, 0.2443461F, 0.0F, 0.0F);
/* 228 */     this.Spine2 = new ModelRenderer(this, 0, 0);
/* 229 */     this.Spine2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5);
/* 230 */     this.Spine2.setRotationPoint(0.0F, 16.0F, -1.2F);
/* 231 */     this.Spine2.setTextureSize(64, 32);
/* 232 */     this.Spine2.mirror = true;
/* 233 */     setRotation(this.Spine2, 0.3141593F, 0.0F, 0.0F);
/* 234 */     this.Spine3 = new ModelRenderer(this, 0, 0);
/* 235 */     this.Spine3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 6);
/* 236 */     this.Spine3.setRotationPoint(0.0F, 16.0F, 1.8F);
/* 237 */     this.Spine3.setTextureSize(64, 32);
/* 238 */     this.Spine3.mirror = true;
/* 239 */     setRotation(this.Spine3, 0.2792527F, 0.0F, 0.0F);
/* 240 */     this.Spine4 = new ModelRenderer(this, 0, 0);
/* 241 */     this.Spine4.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 8);
/* 242 */     this.Spine4.setRotationPoint(0.0F, 16.0F, 3.8F);
/* 243 */     this.Spine4.setTextureSize(64, 32);
/* 244 */     this.Spine4.mirror = true;
/* 245 */     setRotation(this.Spine4, 0.1745329F, 0.0F, 0.0F);
/* 246 */     this.RightArmSeg4 = new ModelRenderer(this, 0, 0);
/* 247 */     this.RightArmSeg4.addBox(-3.2F, -1.0F, -10.5F, 2, 2, 4);
/* 248 */     this.RightArmSeg4.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 249 */     this.RightArmSeg4.setTextureSize(64, 32);
/* 250 */     this.RightArmSeg4.mirror = true;
/* 251 */     setRotation(this.RightArmSeg4, 0.0F, 0.0872665F, 0.0F);
/* 252 */     this.LeftArmSeg1 = new ModelRenderer(this, 0, 13);
/* 253 */     this.LeftArmSeg1.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4);
/* 254 */     this.LeftArmSeg1.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 255 */     this.LeftArmSeg1.setTextureSize(64, 32);
/* 256 */     this.LeftArmSeg1.mirror = true;
/* 257 */     setRotation(this.LeftArmSeg1, 0.0F, -0.5235988F, 0.0F);
/* 258 */     this.LeftArmSeg3 = new ModelRenderer(this, 0, 13);
/* 259 */     this.LeftArmSeg3.addBox(1.0F, -0.5F, -8.0F, 1, 1, 3);
/* 260 */     this.LeftArmSeg3.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 261 */     this.LeftArmSeg3.setTextureSize(64, 32);
/* 262 */     this.LeftArmSeg3.mirror = true;
/* 263 */     setRotation(this.LeftArmSeg3, 0.0F, -0.1745329F, 0.0F);
/* 264 */     this.RightArmSeg2 = new ModelRenderer(this, 0, 0);
/* 265 */     this.RightArmSeg2.addBox(-1.5F, -1.0F, -6.0F, 2, 2, 4);
/* 266 */     this.RightArmSeg2.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 267 */     this.RightArmSeg2.setTextureSize(64, 32);
/* 268 */     this.RightArmSeg2.mirror = true;
/* 269 */     setRotation(this.RightArmSeg2, 0.0F, 0.3490659F, 0.0F);
/* 270 */     this.RightArmSeg1 = new ModelRenderer(this, 0, 13);
/* 271 */     this.RightArmSeg1.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4);
/* 272 */     this.RightArmSeg1.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 273 */     this.RightArmSeg1.setTextureSize(64, 32);
/* 274 */     this.RightArmSeg1.mirror = true;
/* 275 */     setRotation(this.RightArmSeg1, 0.0F, 0.5235988F, 0.0F);
/* 276 */     this.LeftArmSeg5 = new ModelRenderer(this, 0, 13);
/* 277 */     this.LeftArmSeg5.addBox(2.4F, -0.5F, -12.0F, 1, 1, 3);
/* 278 */     this.LeftArmSeg5.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 279 */     this.LeftArmSeg5.setTextureSize(64, 32);
/* 280 */     this.LeftArmSeg5.mirror = true;
/* 281 */     setRotation(this.LeftArmSeg5, 0.0F, 0.0F, 0.0F);
/* 282 */     this.LeftArmSeg2 = new ModelRenderer(this, 0, 0);
/* 283 */     this.LeftArmSeg2.addBox(-0.5F, -1.0F, -6.0F, 2, 2, 4);
/* 284 */     this.LeftArmSeg2.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 285 */     this.LeftArmSeg2.setTextureSize(64, 32);
/* 286 */     this.LeftArmSeg2.mirror = true;
/* 287 */     setRotation(this.LeftArmSeg2, 0.0F, -0.3490659F, 0.0F);
/* 288 */     this.LeftClawTop = new ModelRenderer(this, 15, 15);
/* 289 */     this.LeftClawTop.addBox(1.8F, 4.7F, -15.0F, 2, 2, 5);
/* 290 */     this.LeftClawTop.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 291 */     this.LeftClawTop.setTextureSize(64, 32);
/* 292 */     this.LeftClawTop.mirror = true;
/* 293 */     setRotation(this.LeftClawTop, -0.5410521F, 0.0F, 0.0F);
/* 294 */     this.RightArmSeg3 = new ModelRenderer(this, 0, 13);
/* 295 */     this.RightArmSeg3.addBox(-2.0F, -0.5F, -8.0F, 1, 1, 3);
/* 296 */     this.RightArmSeg3.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 297 */     this.RightArmSeg3.setTextureSize(64, 32);
/* 298 */     this.RightArmSeg3.mirror = true;
/* 299 */     setRotation(this.RightArmSeg3, 0.0F, 0.1745329F, 0.0F);
/* 300 */     this.RightArmSeg5 = new ModelRenderer(this, 0, 13);
/* 301 */     this.RightArmSeg5.addBox(-3.6F, -0.5F, -12.0F, 1, 1, 3);
/* 302 */     this.RightArmSeg5.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 303 */     this.RightArmSeg5.setTextureSize(64, 32);
/* 304 */     this.RightArmSeg5.mirror = true;
/* 305 */     setRotation(this.RightArmSeg5, 0.0F, 0.0F, 0.0F);
/* 306 */     this.LeftArmSeg4 = new ModelRenderer(this, 0, 0);
/* 307 */     this.LeftArmSeg4.addBox(1.1F, -1.0F, -10.5F, 2, 2, 4);
/* 308 */     this.LeftArmSeg4.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 309 */     this.LeftArmSeg4.setTextureSize(64, 32);
/* 310 */     this.LeftArmSeg4.mirror = true;
/* 311 */     setRotation(this.LeftArmSeg4, 0.0F, -0.0872665F, 0.0F);
/* 312 */     this.LeftClawBase = new ModelRenderer(this, 0, 0);
/* 313 */     this.LeftClawBase.addBox(1.8F, -1.0F, -13.0F, 2, 2, 2);
/* 314 */     this.LeftClawBase.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 315 */     this.LeftClawBase.setTextureSize(64, 32);
/* 316 */     this.LeftClawBase.mirror = true;
/* 317 */     setRotation(this.LeftClawBase, 0.0F, 0.0F, 0.0F);
/* 318 */     this.RightClawBase = new ModelRenderer(this, 0, 0);
/* 319 */     this.RightClawBase.addBox(-4.2F, -1.0F, -13.0F, 2, 2, 2);
/* 320 */     this.RightClawBase.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 321 */     this.RightClawBase.setTextureSize(64, 32);
/* 322 */     this.RightClawBase.mirror = true;
/* 323 */     setRotation(this.RightClawBase, 0.0F, 0.0F, 0.0F);
/* 324 */     this.LeftClawLow = new ModelRenderer(this, 25, 25);
/* 325 */     this.LeftClawLow.addBox(1.8F, -4.3F, -15.0F, 2, 1, 4);
/* 326 */     this.LeftClawLow.setRotationPoint(4.7F, 17.5F, -3.0F);
/* 327 */     this.LeftClawLow.setTextureSize(64, 32);
/* 328 */     this.LeftClawLow.mirror = true;
/* 329 */     setRotation(this.LeftClawLow, 0.3490659F, 0.0F, 0.0F);
/* 330 */     this.RightClawTop = new ModelRenderer(this, 15, 15);
/* 331 */     this.RightClawTop.addBox(-4.2F, 4.7F, -15.0F, 2, 2, 5);
/* 332 */     this.RightClawTop.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 333 */     this.RightClawTop.setTextureSize(64, 32);
/* 334 */     this.RightClawTop.mirror = true;
/* 335 */     setRotation(this.RightClawTop, -0.5410521F, 0.0F, 0.0F);
/* 336 */     this.RightClawLow = new ModelRenderer(this, 25, 25);
/* 337 */     this.RightClawLow.addBox(-4.2F, -4.3F, -15.0F, 2, 1, 4);
/* 338 */     this.RightClawLow.setRotationPoint(-4.7F, 17.5F, -3.0F);
/* 339 */     this.RightClawLow.setTextureSize(64, 32);
/* 340 */     this.RightClawLow.mirror = true;
/* 341 */     setRotation(this.RightClawLow, 0.3490659F, 0.0F, 0.0F);
/* 342 */     this.LBLeg1 = new ModelRenderer(this, 0, 13);
/* 343 */     this.LBLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 344 */     this.LBLeg1.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 345 */     this.LBLeg1.setTextureSize(64, 32);
/* 346 */     this.LBLeg1.mirror = true;
/* 347 */     setRotation(this.LBLeg1, 0.0F, 0.0F, -0.4363323F);
/* 348 */     this.LBLeg3 = new ModelRenderer(this, 2, 0);
/* 349 */     this.LBLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 350 */     this.LBLeg3.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 351 */     this.LBLeg3.setTextureSize(64, 32);
/* 352 */     this.LBLeg3.mirror = true;
/* 353 */     setRotation(this.LBLeg3, 0.0F, 0.0F, -0.5759587F);
/* 354 */     this.RBLeg1 = new ModelRenderer(this, 0, 13);
/* 355 */     this.RBLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 356 */     this.RBLeg1.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 357 */     this.RBLeg1.setTextureSize(64, 32);
/* 358 */     this.RBLeg1.mirror = true;
/* 359 */     setRotation(this.RBLeg1, 0.0F, 0.0F, 0.4363323F);
/* 360 */     this.RBLeg3 = new ModelRenderer(this, 2, 0);
/* 361 */     this.RBLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 362 */     this.RBLeg3.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 363 */     this.RBLeg3.setTextureSize(64, 32);
/* 364 */     this.RBLeg3.mirror = true;
/* 365 */     setRotation(this.RBLeg3, 0.0F, 0.0F, 0.5759587F);
/* 366 */     this.LBLeg2 = new ModelRenderer(this, 0, 0);
/* 367 */     this.LBLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 368 */     this.LBLeg2.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 369 */     this.LBLeg2.setTextureSize(64, 32);
/* 370 */     this.LBLeg2.mirror = true;
/* 371 */     setRotation(this.LBLeg2, 0.0F, 0.0F, -0.9599311F);
/* 372 */     this.RBLeg2 = new ModelRenderer(this, 0, 0);
/* 373 */     this.RBLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 374 */     this.RBLeg2.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 375 */     this.RBLeg2.setTextureSize(64, 32);
/* 376 */     this.RBLeg2.mirror = true;
/* 377 */     setRotation(this.RBLeg2, 0.0F, 0.0F, 0.9599311F);
/* 378 */     this.LBLeg4 = new ModelRenderer(this, 0, 13);
/* 379 */     this.LBLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 380 */     this.LBLeg4.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 381 */     this.LBLeg4.setTextureSize(64, 32);
/* 382 */     this.LBLeg4.mirror = true;
/* 383 */     setRotation(this.LBLeg4, 0.0F, 0.0F, -0.2094395F);
/* 384 */     this.RBLeg4 = new ModelRenderer(this, 0, 13);
/* 385 */     this.RBLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 386 */     this.RBLeg4.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 387 */     this.RBLeg4.setTextureSize(64, 32);
/* 388 */     this.RBLeg4.mirror = true;
/* 389 */     setRotation(this.RBLeg4, 0.0F, 0.0F, 0.2094395F);
/* 390 */     this.RBLeg5 = new ModelRenderer(this, 0, 0);
/* 391 */     this.RBLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 392 */     this.RBLeg5.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 393 */     this.RBLeg5.setTextureSize(64, 32);
/* 394 */     this.RBLeg5.mirror = true;
/* 395 */     setRotation(this.RBLeg5, 0.0F, 0.0F, 0.1047198F);
/* 396 */     this.LBLeg6 = new ModelRenderer(this, 0, 13);
/* 397 */     this.LBLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 398 */     this.LBLeg6.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 399 */     this.LBLeg6.setTextureSize(64, 32);
/* 400 */     this.LBLeg6.mirror = true;
/* 401 */     setRotation(this.LBLeg6, 0.0F, 0.0F, 0.0F);
/* 402 */     this.RBLeg6 = new ModelRenderer(this, 0, 13);
/* 403 */     this.RBLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 404 */     this.RBLeg6.setRotationPoint(-5.0F, 18.0F, 8.5F);
/* 405 */     this.RBLeg6.setTextureSize(64, 32);
/* 406 */     this.RBLeg6.mirror = true;
/* 407 */     setRotation(this.RBLeg6, 0.0F, 0.0F, 0.0F);
/* 408 */     this.LBLeg5 = new ModelRenderer(this, 0, 0);
/* 409 */     this.LBLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 410 */     this.LBLeg5.setRotationPoint(5.0F, 18.0F, 8.5F);
/* 411 */     this.LBLeg5.setTextureSize(64, 32);
/* 412 */     this.LBLeg5.mirror = true;
/* 413 */     setRotation(this.LBLeg5, 0.0F, 0.0F, -0.1047198F);
/* 414 */     this.RFLeg1 = new ModelRenderer(this, 0, 13);
/* 415 */     this.RFLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 416 */     this.RFLeg1.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 417 */     this.RFLeg1.setTextureSize(64, 32);
/* 418 */     this.RFLeg1.mirror = true;
/* 419 */     setRotation(this.RFLeg1, 0.0F, 0.0F, 0.4363323F);
/* 420 */     this.RFLeg2 = new ModelRenderer(this, 0, 0);
/* 421 */     this.RFLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 422 */     this.RFLeg2.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 423 */     this.RFLeg2.setTextureSize(64, 32);
/* 424 */     this.RFLeg2.mirror = true;
/* 425 */     setRotation(this.RFLeg2, 0.0F, 0.0F, 0.9599311F);
/* 426 */     this.RFLeg3 = new ModelRenderer(this, 2, 0);
/* 427 */     this.RFLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 428 */     this.RFLeg3.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 429 */     this.RFLeg3.setTextureSize(64, 32);
/* 430 */     this.RFLeg3.mirror = true;
/* 431 */     setRotation(this.RFLeg3, 0.0F, 0.0F, 0.5759587F);
/* 432 */     this.RFLeg4 = new ModelRenderer(this, 0, 13);
/* 433 */     this.RFLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 434 */     this.RFLeg4.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 435 */     this.RFLeg4.setTextureSize(64, 32);
/* 436 */     this.RFLeg4.mirror = true;
/* 437 */     setRotation(this.RFLeg4, 0.0F, 0.0F, 0.2094395F);
/* 438 */     this.RFLeg5 = new ModelRenderer(this, 0, 0);
/* 439 */     this.RFLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 440 */     this.RFLeg5.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 441 */     this.RFLeg5.setTextureSize(64, 32);
/* 442 */     this.RFLeg5.mirror = true;
/* 443 */     setRotation(this.RFLeg5, 0.0F, 0.0F, 0.1047198F);
/* 444 */     this.RFLeg6 = new ModelRenderer(this, 0, 13);
/* 445 */     this.RFLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 446 */     this.RFLeg6.setRotationPoint(-5.0F, 18.0F, 0.5F);
/* 447 */     this.RFLeg6.setTextureSize(64, 32);
/* 448 */     this.RFLeg6.mirror = true;
/* 449 */     setRotation(this.RFLeg6, 0.0F, 0.0F, 0.0F);
/* 450 */     this.RMLeg1 = new ModelRenderer(this, 0, 13);
/* 451 */     this.RMLeg1.addBox(-3.5F, -0.5F, -0.5F, 3, 1, 1);
/* 452 */     this.RMLeg1.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 453 */     this.RMLeg1.setTextureSize(64, 32);
/* 454 */     this.RMLeg1.mirror = true;
/* 455 */     setRotation(this.RMLeg1, 0.0F, 0.0F, 0.4363323F);
/* 456 */     this.RMLeg2 = new ModelRenderer(this, 0, 0);
/* 457 */     this.RMLeg2.addBox(-5.5F, 0.5F, -1.0F, 3, 2, 2);
/* 458 */     this.RMLeg2.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 459 */     this.RMLeg2.setTextureSize(64, 32);
/* 460 */     this.RMLeg2.mirror = true;
/* 461 */     setRotation(this.RMLeg2, 0.0F, 0.0F, 0.9599311F);
/* 462 */     this.RMLeg3 = new ModelRenderer(this, 2, 0);
/* 463 */     this.RMLeg3.addBox(-8.1F, -1.5F, -1.0F, 3, 1, 2);
/* 464 */     this.RMLeg3.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 465 */     this.RMLeg3.setTextureSize(64, 32);
/* 466 */     this.RMLeg3.mirror = true;
/* 467 */     setRotation(this.RMLeg3, 0.0F, 0.0F, 0.5759587F);
/* 468 */     this.RMLeg4 = new ModelRenderer(this, 0, 13);
/* 469 */     this.RMLeg4.addBox(-6.0F, -3.0F, -0.5F, 1, 3, 1);
/* 470 */     this.RMLeg4.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 471 */     this.RMLeg4.setTextureSize(64, 32);
/* 472 */     this.RMLeg4.mirror = true;
/* 473 */     setRotation(this.RMLeg4, 0.0F, 0.0F, 0.2094395F);
/* 474 */     this.RMLeg5 = new ModelRenderer(this, 0, 0);
/* 475 */     this.RMLeg5.addBox(-6.4F, -1.0F, -1.0F, 2, 6, 2);
/* 476 */     this.RMLeg5.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 477 */     this.RMLeg5.setTextureSize(64, 32);
/* 478 */     this.RMLeg5.mirror = true;
/* 479 */     setRotation(this.RMLeg5, 0.0F, 0.0F, 0.1047198F);
/* 480 */     this.RMLeg6 = new ModelRenderer(this, 0, 13);
/* 481 */     this.RMLeg6.addBox(-6.5F, 3.0F, -0.5F, 1, 3, 1);
/* 482 */     this.RMLeg6.setRotationPoint(-5.0F, 18.0F, 4.5F);
/* 483 */     this.RMLeg6.setTextureSize(64, 32);
/* 484 */     this.RMLeg6.mirror = true;
/* 485 */     setRotation(this.RMLeg6, 0.0F, 0.0F, 0.0F);
/* 486 */     this.LFLeg1 = new ModelRenderer(this, 0, 13);
/* 487 */     this.LFLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 488 */     this.LFLeg1.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 489 */     this.LFLeg1.setTextureSize(64, 32);
/* 490 */     this.LFLeg1.mirror = true;
/* 491 */     setRotation(this.LFLeg1, 0.0F, 0.0F, -0.4363323F);
/* 492 */     this.LFLeg2 = new ModelRenderer(this, 0, 0);
/* 493 */     this.LFLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 494 */     this.LFLeg2.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 495 */     this.LFLeg2.setTextureSize(64, 32);
/* 496 */     this.LFLeg2.mirror = true;
/* 497 */     setRotation(this.LFLeg2, 0.0F, 0.0F, -0.9599311F);
/* 498 */     this.LFLeg3 = new ModelRenderer(this, 2, 0);
/* 499 */     this.LFLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 500 */     this.LFLeg3.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 501 */     this.LFLeg3.setTextureSize(64, 32);
/* 502 */     this.LFLeg3.mirror = true;
/* 503 */     setRotation(this.LFLeg3, 0.0F, 0.0F, -0.5759587F);
/* 504 */     this.LFLeg4 = new ModelRenderer(this, 0, 13);
/* 505 */     this.LFLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 506 */     this.LFLeg4.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 507 */     this.LFLeg4.setTextureSize(64, 32);
/* 508 */     this.LFLeg4.mirror = true;
/* 509 */     setRotation(this.LFLeg4, 0.0F, 0.0F, -0.2094395F);
/* 510 */     this.LFLeg5 = new ModelRenderer(this, 0, 0);
/* 511 */     this.LFLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 512 */     this.LFLeg5.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 513 */     this.LFLeg5.setTextureSize(64, 32);
/* 514 */     this.LFLeg5.mirror = true;
/* 515 */     setRotation(this.LFLeg5, 0.0F, 0.0F, -0.1047198F);
/* 516 */     this.LFLeg6 = new ModelRenderer(this, 0, 13);
/* 517 */     this.LFLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 518 */     this.LFLeg6.setRotationPoint(5.0F, 18.0F, 0.5F);
/* 519 */     this.LFLeg6.setTextureSize(64, 32);
/* 520 */     this.LFLeg6.mirror = true;
/* 521 */     setRotation(this.LFLeg6, 0.0F, 0.0F, 0.0F);
/* 522 */     this.LMLeg1 = new ModelRenderer(this, 0, 13);
/* 523 */     this.LMLeg1.addBox(0.5F, -0.5F, -0.5F, 3, 1, 1);
/* 524 */     this.LMLeg1.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 525 */     this.LMLeg1.setTextureSize(64, 32);
/* 526 */     this.LMLeg1.mirror = true;
/* 527 */     setRotation(this.LMLeg1, 0.0F, 0.0F, -0.4363323F);
/* 528 */     this.LMLeg2 = new ModelRenderer(this, 0, 0);
/* 529 */     this.LMLeg2.addBox(2.5F, 0.5F, -1.0F, 3, 2, 2);
/* 530 */     this.LMLeg2.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 531 */     this.LMLeg2.setTextureSize(64, 32);
/* 532 */     this.LMLeg2.mirror = true;
/* 533 */     setRotation(this.LMLeg2, 0.0F, 0.0F, -0.9599311F);
/* 534 */     this.LMLeg4 = new ModelRenderer(this, 0, 13);
/* 535 */     this.LMLeg4.addBox(5.0F, -3.0F, -0.5F, 1, 3, 1);
/* 536 */     this.LMLeg4.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 537 */     this.LMLeg4.setTextureSize(64, 32);
/* 538 */     this.LMLeg4.mirror = true;
/* 539 */     setRotation(this.LMLeg4, 0.0F, 0.0F, -0.2094395F);
/* 540 */     this.LMLeg3 = new ModelRenderer(this, 2, 0);
/* 541 */     this.LMLeg3.addBox(5.1F, -1.5F, -1.0F, 3, 1, 2);
/* 542 */     this.LMLeg3.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 543 */     this.LMLeg3.setTextureSize(64, 32);
/* 544 */     this.LMLeg3.mirror = true;
/* 545 */     setRotation(this.LMLeg3, 0.0F, 0.0F, -0.5759587F);
/* 546 */     this.LMLeg5 = new ModelRenderer(this, 0, 0);
/* 547 */     this.LMLeg5.addBox(4.6F, -1.0F, -1.0F, 2, 6, 2);
/* 548 */     this.LMLeg5.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 549 */     this.LMLeg5.setTextureSize(64, 32);
/* 550 */     this.LMLeg5.mirror = true;
/* 551 */     setRotation(this.LMLeg5, 0.0F, 0.0F, -0.1047198F);
/* 552 */     this.LMLeg6 = new ModelRenderer(this, 0, 13);
/* 553 */     this.LMLeg6.addBox(5.5F, 3.0F, -0.5F, 1, 3, 1);
/* 554 */     this.LMLeg6.setRotationPoint(5.0F, 18.0F, 4.5F);
/* 555 */     this.LMLeg6.setTextureSize(64, 32);
/* 556 */     this.LMLeg6.mirror = true;
/* 557 */     setRotation(this.LMLeg6, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 564 */     CaveFisher e = (CaveFisher)entity;
/* 565 */     RenderInfo r = null;
/* 566 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 567 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 568 */     float newangle = 0.0F, upangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */     
/* 571 */     float pi4 = 1.570795F;
/*     */ 
/*     */     
/* 574 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/* 575 */     this.LFLeg1.rotateAngleY = newangle;
/* 576 */     this.LFLeg2.rotateAngleY = newangle;
/* 577 */     this.LFLeg3.rotateAngleY = newangle;
/* 578 */     this.LFLeg4.rotateAngleY = newangle;
/* 579 */     this.LFLeg5.rotateAngleY = newangle;
/* 580 */     this.LFLeg6.rotateAngleY = newangle;
/* 581 */     this.RFLeg1.rotateAngleY = -newangle;
/* 582 */     this.RFLeg2.rotateAngleY = -newangle;
/* 583 */     this.RFLeg3.rotateAngleY = -newangle;
/* 584 */     this.RFLeg4.rotateAngleY = -newangle;
/* 585 */     this.RFLeg5.rotateAngleY = -newangle;
/* 586 */     this.RFLeg6.rotateAngleY = -newangle;
/*     */     
/* 588 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 1.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 589 */     this.LMLeg1.rotateAngleY = newangle;
/* 590 */     this.LMLeg2.rotateAngleY = newangle;
/* 591 */     this.LMLeg3.rotateAngleY = newangle;
/* 592 */     this.LMLeg4.rotateAngleY = newangle;
/* 593 */     this.LMLeg5.rotateAngleY = newangle;
/* 594 */     this.LMLeg6.rotateAngleY = newangle;
/* 595 */     this.RMLeg1.rotateAngleY = -newangle;
/* 596 */     this.RMLeg2.rotateAngleY = -newangle;
/* 597 */     this.RMLeg3.rotateAngleY = -newangle;
/* 598 */     this.RMLeg4.rotateAngleY = -newangle;
/* 599 */     this.RMLeg5.rotateAngleY = -newangle;
/* 600 */     this.RMLeg6.rotateAngleY = -newangle;
/*     */     
/* 602 */     newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.12F * f1;
/* 603 */     this.LBLeg1.rotateAngleY = newangle;
/* 604 */     this.LBLeg2.rotateAngleY = newangle;
/* 605 */     this.LBLeg3.rotateAngleY = newangle;
/* 606 */     this.LBLeg4.rotateAngleY = newangle;
/* 607 */     this.LBLeg5.rotateAngleY = newangle;
/* 608 */     this.LBLeg6.rotateAngleY = newangle;
/* 609 */     this.RBLeg1.rotateAngleY = -newangle;
/* 610 */     this.RBLeg2.rotateAngleY = -newangle;
/* 611 */     this.RBLeg3.rotateAngleY = -newangle;
/* 612 */     this.RBLeg4.rotateAngleY = -newangle;
/* 613 */     this.RBLeg5.rotateAngleY = -newangle;
/* 614 */     this.RBLeg6.rotateAngleY = -newangle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 620 */     r = e.getRenderInfo();
/*     */ 
/*     */     
/* 623 */     newangle = MathHelper.cos(f2 * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 624 */     nextangle = MathHelper.cos((f2 + 0.1F) * 3.0F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 629 */     if (nextangle > 0.0F && newangle < 0.0F) {
/*     */       
/* 631 */       r.ri1 = 0;
/* 632 */       if (e.getAttacking() == 0) {
/* 633 */         r.ri1 = e.worldObj.rand.nextInt(20);
/* 634 */         r.ri2 = e.worldObj.rand.nextInt(25);
/*     */       } else {
/* 636 */         r.ri1 = e.worldObj.rand.nextInt(4);
/* 637 */         r.ri2 = e.worldObj.rand.nextInt(3);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 642 */     if (r.ri1 == 1 || r.ri1 == 3) {
/* 643 */       doLeftClaw(newangle);
/* 644 */       doRightClaw(newangle);
/*     */     } else {
/* 646 */       doLeftClaw(0.0F);
/* 647 */       doRightClaw(0.0F);
/*     */     } 
/*     */ 
/*     */     
/* 651 */     e.setRenderInfo(r);
/*     */     
/* 653 */     this.Nose.render(f5);
/* 654 */     this.EyeLeft.render(f5);
/* 655 */     this.HeadMid.render(f5);
/* 656 */     this.HeadEnd.render(f5);
/* 657 */     this.TailTuft.render(f5);
/* 658 */     this.EyeRight.render(f5);
/* 659 */     this.BodyTopLeft4.render(f5);
/* 660 */     this.BodyTopRight4.render(f5);
/* 661 */     this.BodyTopLeft1.render(f5);
/* 662 */     this.BodyTopRight1.render(f5);
/* 663 */     this.BodyTopRight2.render(f5);
/* 664 */     this.BodyTopLeft2.render(f5);
/* 665 */     this.BodyTopRight3.render(f5);
/* 666 */     this.BodyTopLeft3.render(f5);
/* 667 */     this.HeadBase.render(f5);
/* 668 */     this.TailBase.render(f5);
/* 669 */     this.BodyLow2.render(f5);
/* 670 */     this.BodyLow1.render(f5);
/* 671 */     this.Spine5.render(f5);
/* 672 */     this.Spine1.render(f5);
/* 673 */     this.Spine2.render(f5);
/* 674 */     this.Spine3.render(f5);
/* 675 */     this.Spine4.render(f5);
/* 676 */     this.RightArmSeg4.render(f5);
/* 677 */     this.LeftArmSeg1.render(f5);
/* 678 */     this.LeftArmSeg3.render(f5);
/* 679 */     this.RightArmSeg2.render(f5);
/* 680 */     this.RightArmSeg1.render(f5);
/* 681 */     this.LeftArmSeg5.render(f5);
/* 682 */     this.LeftArmSeg2.render(f5);
/* 683 */     this.LeftClawTop.render(f5);
/* 684 */     this.RightArmSeg3.render(f5);
/* 685 */     this.RightArmSeg5.render(f5);
/* 686 */     this.LeftArmSeg4.render(f5);
/* 687 */     this.LeftClawBase.render(f5);
/* 688 */     this.RightClawBase.render(f5);
/* 689 */     this.LeftClawLow.render(f5);
/* 690 */     this.RightClawTop.render(f5);
/* 691 */     this.RightClawLow.render(f5);
/* 692 */     this.LBLeg1.render(f5);
/* 693 */     this.LBLeg3.render(f5);
/* 694 */     this.RBLeg1.render(f5);
/* 695 */     this.RBLeg3.render(f5);
/* 696 */     this.LBLeg2.render(f5);
/* 697 */     this.RBLeg2.render(f5);
/* 698 */     this.LBLeg4.render(f5);
/* 699 */     this.RBLeg4.render(f5);
/* 700 */     this.RBLeg5.render(f5);
/* 701 */     this.LBLeg6.render(f5);
/* 702 */     this.RBLeg6.render(f5);
/* 703 */     this.LBLeg5.render(f5);
/* 704 */     this.RFLeg1.render(f5);
/* 705 */     this.RFLeg2.render(f5);
/* 706 */     this.RFLeg3.render(f5);
/* 707 */     this.RFLeg4.render(f5);
/* 708 */     this.RFLeg5.render(f5);
/* 709 */     this.RFLeg6.render(f5);
/* 710 */     this.RMLeg1.render(f5);
/* 711 */     this.RMLeg2.render(f5);
/* 712 */     this.RMLeg3.render(f5);
/* 713 */     this.RMLeg4.render(f5);
/* 714 */     this.RMLeg5.render(f5);
/* 715 */     this.RMLeg6.render(f5);
/* 716 */     this.LFLeg1.render(f5);
/* 717 */     this.LFLeg2.render(f5);
/* 718 */     this.LFLeg3.render(f5);
/* 719 */     this.LFLeg4.render(f5);
/* 720 */     this.LFLeg5.render(f5);
/* 721 */     this.LFLeg6.render(f5);
/* 722 */     this.LMLeg1.render(f5);
/* 723 */     this.LMLeg2.render(f5);
/* 724 */     this.LMLeg4.render(f5);
/* 725 */     this.LMLeg3.render(f5);
/* 726 */     this.LMLeg5.render(f5);
/* 727 */     this.LMLeg6.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 733 */     model.rotateAngleX = x;
/* 734 */     model.rotateAngleY = y;
/* 735 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 741 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 747 */     this.LeftArmSeg1.rotateAngleX = Math.abs(angle);
/* 748 */     this.LeftArmSeg2.rotateAngleX = Math.abs(angle);
/* 749 */     this.LeftArmSeg3.rotateAngleX = Math.abs(angle);
/* 750 */     this.LeftArmSeg4.rotateAngleX = Math.abs(angle);
/* 751 */     this.LeftArmSeg5.rotateAngleX = Math.abs(angle);
/* 752 */     this.LeftClawBase.rotateAngleX = Math.abs(angle);
/* 753 */     this.LeftClawTop.rotateAngleX = Math.abs(angle) - 0.54F;
/* 754 */     this.LeftClawLow.rotateAngleX = Math.abs(angle) + 0.35F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 759 */     this.RightArmSeg1.rotateAngleX = Math.abs(angle);
/* 760 */     this.RightArmSeg2.rotateAngleX = Math.abs(angle);
/* 761 */     this.RightArmSeg3.rotateAngleX = Math.abs(angle);
/* 762 */     this.RightArmSeg4.rotateAngleX = Math.abs(angle);
/* 763 */     this.RightArmSeg5.rotateAngleX = Math.abs(angle);
/* 764 */     this.RightClawBase.rotateAngleX = Math.abs(angle);
/* 765 */     this.RightClawTop.rotateAngleX = Math.abs(angle) - 0.54F;
/* 766 */     this.RightClawLow.rotateAngleX = Math.abs(angle) + 0.35F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCaveFisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */