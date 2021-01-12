/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGodzilla
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer LToe1;
/*     */   
/*     */   ModelRenderer LToe3;
/*     */   
/*     */   ModelRenderer LToe2;
/*     */   
/*     */   ModelRenderer LToe9;
/*     */   ModelRenderer LToe8;
/*     */   ModelRenderer LToe7;
/*     */   ModelRenderer LToe6;
/*     */   ModelRenderer LToe5;
/*     */   ModelRenderer LToe4;
/*     */   ModelRenderer RToe9;
/*     */   ModelRenderer RToe6;
/*     */   ModelRenderer RToe5;
/*     */   ModelRenderer RToe2;
/*     */   ModelRenderer RToe1;
/*     */   ModelRenderer RToe4;
/*     */   ModelRenderer RToe7;
/*     */   ModelRenderer RToe8;
/*     */   ModelRenderer RToe3;
/*     */   ModelRenderer LThigh;
/*     */   ModelRenderer LLowerLeg;
/*     */   ModelRenderer LUpperLeg;
/*     */   ModelRenderer TailTip;
/*     */   ModelRenderer RLegLower;
/*     */   ModelRenderer RLegUpper;
/*     */   ModelRenderer RThigh;
/*     */   ModelRenderer LowerJaw;
/*     */   ModelRenderer TailBase;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail3;
/*     */   ModelRenderer Tail4;
/*     */   ModelRenderer Tail5;
/*     */   ModelRenderer Tail6;
/*     */   ModelRenderer Tail7;
/*     */   ModelRenderer BodyBottom;
/*     */   ModelRenderer RLowerArm;
/*     */   ModelRenderer BodyCenter;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer TopJaw;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer BodyTop;
/*     */   ModelRenderer RShoulder;
/*     */   ModelRenderer RThumbTip;
/*     */   ModelRenderer RUpperArm;
/*     */   ModelRenderer RHand;
/*     */   ModelRenderer RThumbBase;
/*     */   ModelRenderer R3rdFingerTip;
/*     */   ModelRenderer R3rdFingerBase;
/*     */   ModelRenderer RIndexTip;
/*     */   ModelRenderer RIndexBase;
/*     */   ModelRenderer LShoulder;
/*     */   ModelRenderer LUpperArm;
/*     */   ModelRenderer LLowerArm;
/*     */   ModelRenderer LIndexBase;
/*     */   ModelRenderer LIndexTip;
/*     */   ModelRenderer LHand;
/*     */   ModelRenderer LThumbBase;
/*     */   ModelRenderer LThumbTip;
/*     */   ModelRenderer L3rdFingerTip;
/*     */   ModelRenderer L3rdFingerBase;
/*     */   ModelRenderer Lspikes1;
/*     */   ModelRenderer Rspikes1;
/*     */   ModelRenderer Lspike2;
/*     */   ModelRenderer Rspike2;
/*     */   ModelRenderer Lspike3;
/*     */   ModelRenderer Rspike3;
/*     */   ModelRenderer Lspike4;
/*     */   ModelRenderer Rspike4;
/*     */   ModelRenderer Lspike5;
/*     */   ModelRenderer Rspike5;
/*     */   ModelRenderer Spike6;
/*     */   ModelRenderer Spikes7;
/*     */   
/*     */   public ModelGodzilla(float f1) {
/*  88 */     this.wingspeed = f1;
/*     */     
/*  90 */     this.textureWidth = 1024;
/*  91 */     this.textureHeight = 1024;
/*     */     
/*  93 */     this.LToe1 = new ModelRenderer(this, 45, 1002);
/*  94 */     this.LToe1.addBox(-5.0F, -2.0F, -40.0F, 10, 10, 6);
/*  95 */     this.LToe1.setRotationPoint(54.0F, 16.0F, 6.0F);
/*  96 */     this.LToe1.setTextureSize(1024, 1024);
/*  97 */     this.LToe1.mirror = true;
/*  98 */     setRotation(this.LToe1, 0.0F, 0.7853982F, 0.0F);
/*  99 */     this.LToe3 = new ModelRenderer(this, 0, 955);
/* 100 */     this.LToe3.addBox(-8.0F, -8.0F, -26.0F, 16, 16, 30);
/* 101 */     this.LToe3.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 102 */     this.LToe3.setTextureSize(1024, 1024);
/* 103 */     this.LToe3.mirror = true;
/* 104 */     setRotation(this.LToe3, 0.0F, 0.7853982F, 0.0F);
/* 105 */     this.LToe2 = new ModelRenderer(this, 0, 1002);
/* 106 */     this.LToe2.addBox(-7.0F, -6.0F, -34.0F, 14, 14, 8);
/* 107 */     this.LToe2.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 108 */     this.LToe2.setTextureSize(1024, 1024);
/* 109 */     this.LToe2.mirror = true;
/* 110 */     setRotation(this.LToe2, 0.0F, 0.7853982F, 0.0F);
/* 111 */     this.LToe9 = new ModelRenderer(this, 0, 955);
/* 112 */     this.LToe9.addBox(-8.0F, -8.0F, -26.0F, 16, 16, 30);
/* 113 */     this.LToe9.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 114 */     this.LToe9.setTextureSize(1024, 1024);
/* 115 */     this.LToe9.mirror = true;
/* 116 */     setRotation(this.LToe9, 0.0F, -0.7853982F, 0.0F);
/* 117 */     this.LToe8 = new ModelRenderer(this, 0, 1002);
/* 118 */     this.LToe8.addBox(-7.0F, -6.0F, -34.0F, 14, 14, 8);
/* 119 */     this.LToe8.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 120 */     this.LToe8.setTextureSize(1024, 1024);
/* 121 */     this.LToe8.mirror = true;
/* 122 */     setRotation(this.LToe8, 0.0F, -0.7853982F, 0.0F);
/* 123 */     this.LToe7 = new ModelRenderer(this, 45, 1002);
/* 124 */     this.LToe7.addBox(-5.0F, -2.0F, -40.0F, 10, 10, 6);
/* 125 */     this.LToe7.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 126 */     this.LToe7.setTextureSize(1024, 1024);
/* 127 */     this.LToe7.mirror = true;
/* 128 */     setRotation(this.LToe7, 0.0F, -0.7853982F, 0.0F);
/* 129 */     this.LToe6 = new ModelRenderer(this, 92, 955);
/* 130 */     this.LToe6.addBox(-8.0F, -8.0F, -26.0F, 16, 16, 36);
/* 131 */     this.LToe6.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 132 */     this.LToe6.setTextureSize(1024, 1024);
/* 133 */     this.LToe6.mirror = true;
/* 134 */     setRotation(this.LToe6, 0.0F, 0.0F, 0.0F);
/* 135 */     this.LToe5 = new ModelRenderer(this, 0, 1002);
/* 136 */     this.LToe5.addBox(-7.0F, -6.0F, -34.0F, 14, 14, 8);
/* 137 */     this.LToe5.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 138 */     this.LToe5.setTextureSize(1024, 1024);
/* 139 */     this.LToe5.mirror = true;
/* 140 */     setRotation(this.LToe5, 0.0F, 0.0F, 0.0F);
/* 141 */     this.LToe4 = new ModelRenderer(this, 45, 1002);
/* 142 */     this.LToe4.addBox(-5.0F, -2.0F, -40.0F, 10, 10, 6);
/* 143 */     this.LToe4.setRotationPoint(54.0F, 16.0F, 6.0F);
/* 144 */     this.LToe4.setTextureSize(1024, 1024);
/* 145 */     this.LToe4.mirror = true;
/* 146 */     setRotation(this.LToe4, 0.0F, 0.0F, 0.0F);
/* 147 */     this.RToe9 = new ModelRenderer(this, 0, 955);
/* 148 */     this.RToe9.addBox(-8.0F, -8.0F, -26.0F, 16, 16, 30);
/* 149 */     this.RToe9.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 150 */     this.RToe9.setTextureSize(1024, 1024);
/* 151 */     this.RToe9.mirror = true;
/* 152 */     setRotation(this.RToe9, 0.0F, 0.7853982F, 0.0F);
/* 153 */     this.RToe6 = new ModelRenderer(this, 92, 955);
/* 154 */     this.RToe6.addBox(-8.0F, -8.0F, -26.0F, 16, 16, 36);
/* 155 */     this.RToe6.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 156 */     this.RToe6.setTextureSize(1024, 1024);
/* 157 */     this.RToe6.mirror = true;
/* 158 */     setRotation(this.RToe6, 0.0F, 0.0F, 0.0F);
/* 159 */     this.RToe5 = new ModelRenderer(this, 0, 1002);
/* 160 */     this.RToe5.addBox(-7.0F, -6.0F, -34.0F, 14, 14, 8);
/* 161 */     this.RToe5.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 162 */     this.RToe5.setTextureSize(1024, 1024);
/* 163 */     this.RToe5.mirror = true;
/* 164 */     setRotation(this.RToe5, 0.0F, 0.0F, 0.0F);
/* 165 */     this.RToe2 = new ModelRenderer(this, 0, 1002);
/* 166 */     this.RToe2.addBox(-7.0F, -6.0F, -34.0F, 14, 14, 8);
/* 167 */     this.RToe2.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 168 */     this.RToe2.setTextureSize(1024, 1024);
/* 169 */     this.RToe2.mirror = true;
/* 170 */     setRotation(this.RToe2, 0.0F, -0.7853982F, 0.0F);
/* 171 */     this.RToe1 = new ModelRenderer(this, 45, 1002);
/* 172 */     this.RToe1.addBox(-5.0F, -2.0F, -40.0F, 10, 10, 6);
/* 173 */     this.RToe1.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 174 */     this.RToe1.setTextureSize(1024, 1024);
/* 175 */     this.RToe1.mirror = true;
/* 176 */     setRotation(this.RToe1, 0.0F, -0.7853982F, 0.0F);
/* 177 */     this.RToe4 = new ModelRenderer(this, 45, 1002);
/* 178 */     this.RToe4.addBox(-5.0F, -2.0F, -40.0F, 10, 10, 6);
/* 179 */     this.RToe4.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 180 */     this.RToe4.setTextureSize(1024, 1024);
/* 181 */     this.RToe4.mirror = true;
/* 182 */     setRotation(this.RToe4, 0.0F, 0.0F, 0.0F);
/* 183 */     this.RToe7 = new ModelRenderer(this, 45, 1002);
/* 184 */     this.RToe7.addBox(-5.0F, -2.0F, -40.0F, 10, 10, 6);
/* 185 */     this.RToe7.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 186 */     this.RToe7.setTextureSize(1024, 1024);
/* 187 */     this.RToe7.mirror = true;
/* 188 */     setRotation(this.RToe7, 0.0F, 0.7853982F, 0.0F);
/* 189 */     this.RToe8 = new ModelRenderer(this, 0, 1002);
/* 190 */     this.RToe8.addBox(-7.0F, -6.0F, -34.0F, 14, 14, 8);
/* 191 */     this.RToe8.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 192 */     this.RToe8.setTextureSize(1024, 1024);
/* 193 */     this.RToe8.mirror = true;
/* 194 */     setRotation(this.RToe8, 0.0F, 0.7853982F, 0.0F);
/* 195 */     this.RToe3 = new ModelRenderer(this, 0, 955);
/* 196 */     this.RToe3.addBox(-8.0F, -8.0F, -26.0F, 16, 16, 30);
/* 197 */     this.RToe3.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 198 */     this.RToe3.setTextureSize(1024, 1024);
/* 199 */     this.RToe3.mirror = true;
/* 200 */     setRotation(this.RToe3, 0.0F, -0.7853982F, 0.0F);
/* 201 */     this.LThigh = new ModelRenderer(this, 192, 350);
/* 202 */     this.LThigh.addBox(0.0F, -14.0F, -21.0F, 28, 28, 42);
/* 203 */     this.LThigh.setRotationPoint(40.0F, -91.0F, 2.0F);
/* 204 */     this.LThigh.setTextureSize(1024, 1024);
/* 205 */     this.LThigh.mirror = true;
/* 206 */     setRotation(this.LThigh, -0.5585054F, 0.0F, 0.0F);
/* 207 */     this.LLowerLeg = new ModelRenderer(this, 202, 556);
/* 208 */     this.LLowerLeg.addBox(-15.0F, -62.0F, -15.0F, 30, 62, 30);
/* 209 */     this.LLowerLeg.setRotationPoint(54.0F, 14.0F, 6.0F);
/* 210 */     this.LLowerLeg.setTextureSize(1024, 1024);
/* 211 */     this.LLowerLeg.mirror = true;
/* 212 */     setRotation(this.LLowerLeg, 0.1745329F, -0.1308997F, 0.0F);
/* 213 */     this.LUpperLeg = new ModelRenderer(this, 152, 420);
/* 214 */     this.LUpperLeg.addBox(-16.0F, -52.0F, -16.0F, 32, 52, 32);
/* 215 */     this.LUpperLeg.setRotationPoint(56.0F, -36.0F, -5.0F);
/* 216 */     this.LUpperLeg.setTextureSize(1024, 1024);
/* 217 */     this.LUpperLeg.mirror = true;
/* 218 */     setRotation(this.LUpperLeg, -0.1745329F, -0.3926991F, -0.0872665F);
/* 219 */     this.TailTip = new ModelRenderer(this, 0, 694);
/* 220 */     this.TailTip.addBox(-6.0F, 0.0F, -5.0F, 12, 21, 10);
/* 221 */     this.TailTip.setRotationPoint(0.0F, 18.0F, 203.0F);
/* 222 */     this.TailTip.setTextureSize(1024, 1024);
/* 223 */     this.TailTip.mirror = true;
/* 224 */     setRotation(this.TailTip, 1.53589F, 0.0F, 0.0F);
/* 225 */     this.RLegLower = new ModelRenderer(this, 200, 646);
/* 226 */     this.RLegLower.addBox(-15.0F, -62.0F, -15.0F, 30, 62, 30);
/* 227 */     this.RLegLower.setRotationPoint(-54.0F, 16.0F, 6.0F);
/* 228 */     this.RLegLower.setTextureSize(1024, 1024);
/* 229 */     this.RLegLower.mirror = true;
/* 230 */     setRotation(this.RLegLower, 0.1745329F, 0.1308997F, 0.0F);
/* 231 */     this.RLegUpper = new ModelRenderer(this, 152, 420);
/* 232 */     this.RLegUpper.addBox(-16.0F, -52.0F, -16.0F, 32, 52, 32);
/* 233 */     this.RLegUpper.setRotationPoint(-56.0F, -36.0F, -5.0F);
/* 234 */     this.RLegUpper.setTextureSize(1024, 1024);
/* 235 */     this.RLegUpper.mirror = true;
/* 236 */     setRotation(this.RLegUpper, -0.1745329F, 0.3926991F, 0.0872665F);
/* 237 */     this.RThigh = new ModelRenderer(this, 192, 350);
/* 238 */     this.RThigh.addBox(-28.0F, -14.0F, -21.0F, 28, 28, 42);
/* 239 */     this.RThigh.setRotationPoint(-40.0F, -91.0F, 2.0F);
/* 240 */     this.RThigh.setTextureSize(1024, 1024);
/* 241 */     this.RThigh.mirror = true;
/* 242 */     setRotation(this.RThigh, -0.5585054F, 0.0F, 0.0F);
/* 243 */     this.LowerJaw = new ModelRenderer(this, 272, 0);
/* 244 */     this.LowerJaw.addBox(-13.0F, -5.0F, -50.0F, 26, 11, 50);
/* 245 */     this.LowerJaw.setRotationPoint(0.0F, -142.0F, -109.0F);
/* 246 */     this.LowerJaw.setTextureSize(1024, 1024);
/* 247 */     this.LowerJaw.mirror = true;
/* 248 */     setRotation(this.LowerJaw, 0.5235988F, 0.0F, 0.0F);
/* 249 */     this.TailBase = new ModelRenderer(this, 0, 240);
/* 250 */     this.TailBase.addBox(-32.0F, 0.0F, -29.0F, 64, 40, 58);
/* 251 */     this.TailBase.setRotationPoint(0.0F, -73.0F, 26.0F);
/* 252 */     this.TailBase.setTextureSize(1024, 1024);
/* 253 */     this.TailBase.mirror = true;
/* 254 */     setRotation(this.TailBase, 0.7853982F, 0.0F, 0.0F);
/* 255 */     this.Tail2 = new ModelRenderer(this, 0, 338);
/* 256 */     this.Tail2.addBox(-25.0F, 0.0F, -23.0F, 50, 36, 46);
/* 257 */     this.Tail2.setRotationPoint(0.0F, -48.0F, 48.0F);
/* 258 */     this.Tail2.setTextureSize(1024, 1024);
/* 259 */     this.Tail2.mirror = true;
/* 260 */     setRotation(this.Tail2, 0.6981317F, 0.0F, 0.0F);
/* 261 */     this.Tail3 = new ModelRenderer(this, 0, 420);
/* 262 */     this.Tail3.addBox(-20.0F, 0.0F, -18.0F, 40, 36, 36);
/* 263 */     this.Tail3.setRotationPoint(0.0F, -24.0F, 66.0F);
/* 264 */     this.Tail3.setTextureSize(1024, 1024);
/* 265 */     this.Tail3.mirror = true;
/* 266 */     setRotation(this.Tail3, 0.8726646F, 0.0F, 0.0F);
/* 267 */     this.Tail4 = new ModelRenderer(this, 0, 492);
/* 268 */     this.Tail4.addBox(-16.0F, 0.0F, -14.0F, 32, 42, 28);
/* 269 */     this.Tail4.setRotationPoint(0.0F, -3.0F, 87.0F);
/* 270 */     this.Tail4.setTextureSize(1024, 1024);
/* 271 */     this.Tail4.mirror = true;
/* 272 */     setRotation(this.Tail4, 1.134464F, 0.0F, 0.0F);
/* 273 */     this.Tail5 = new ModelRenderer(this, 0, 556);
/* 274 */     this.Tail5.addBox(-13.0F, 0.0F, -11.0F, 26, 42, 22);
/* 275 */     this.Tail5.setRotationPoint(0.0F, 12.0F, 116.0F);
/* 276 */     this.Tail5.setTextureSize(1024, 1024);
/* 277 */     this.Tail5.mirror = true;
/* 278 */     setRotation(this.Tail5, 1.53589F, 0.0F, 0.0F);
/* 279 */     this.Tail6 = new ModelRenderer(this, 0, 614);
/* 280 */     this.Tail6.addBox(-10.0F, 0.0F, -9.0F, 20, 32, 18);
/* 281 */     this.Tail6.setRotationPoint(0.0F, 14.0F, 154.0F);
/* 282 */     this.Tail6.setTextureSize(1024, 1024);
/* 283 */     this.Tail6.mirror = true;
/* 284 */     setRotation(this.Tail6, 1.53589F, 0.0F, 0.0F);
/* 285 */     this.Tail7 = new ModelRenderer(this, 0, 658);
/* 286 */     this.Tail7.addBox(-8.0F, 0.0F, -7.0F, 16, 22, 14);
/* 287 */     this.Tail7.setRotationPoint(0.0F, 16.0F, 185.0F);
/* 288 */     this.Tail7.setTextureSize(1024, 1024);
/* 289 */     this.Tail7.mirror = true;
/* 290 */     setRotation(this.Tail7, 1.53589F, 0.0F, 0.0F);
/* 291 */     this.BodyBottom = new ModelRenderer(this, 0, 104);
/* 292 */     this.BodyBottom.addBox(-40.0F, 0.0F, -36.0F, 80, 64, 72);
/* 293 */     this.BodyBottom.setRotationPoint(0.0F, -112.0F, -20.0F);
/* 294 */     this.BodyBottom.setTextureSize(1024, 1024);
/* 295 */     this.BodyBottom.mirror = true;
/* 296 */     setRotation(this.BodyBottom, 0.8726646F, 0.0F, 0.0F);
/* 297 */     this.RLowerArm = new ModelRenderer(this, 245, 240);
/* 298 */     this.RLowerArm.addBox(-48.0F, -11.0F, -11.0F, 48, 22, 22);
/* 299 */     this.RLowerArm.setRotationPoint(-80.0F, -115.0F, -61.0F);
/* 300 */     this.RLowerArm.setTextureSize(1024, 1024);
/* 301 */     this.RLowerArm.mirror = true;
/* 302 */     setRotation(this.RLowerArm, 0.0F, -0.7853982F, -0.2617994F);
/* 303 */     this.BodyCenter = new ModelRenderer(this, 0, 0);
/* 304 */     this.BodyCenter.addBox(-36.0F, -32.0F, -32.0F, 72, 40, 64);
/* 305 */     this.BodyCenter.setRotationPoint(0.0F, -112.0F, -20.0F);
/* 306 */     this.BodyCenter.setTextureSize(1024, 1024);
/* 307 */     this.BodyCenter.mirror = true;
/* 308 */     setRotation(this.BodyCenter, 1.134464F, 0.0F, 0.0F);
/* 309 */     this.Neck = new ModelRenderer(this, 0, 720);
/* 310 */     this.Neck.addBox(-23.0F, -23.0F, -32.0F, 46, 46, 32);
/* 311 */     this.Neck.setRotationPoint(0.0F, -144.0F, -71.0F);
/* 312 */     this.Neck.setTextureSize(1024, 1024);
/* 313 */     this.Neck.mirror = true;
/* 314 */     setRotation(this.Neck, -0.0698132F, 0.0F, 0.0F);
/* 315 */     this.TopJaw = new ModelRenderer(this, 0, 892);
/* 316 */     this.TopJaw.addBox(-14.0F, -8.0F, -73.0F, 28, 26, 33);
/* 317 */     this.TopJaw.setRotationPoint(0.0F, -156.0F, -98.0F);
/* 318 */     this.TopJaw.setTextureSize(1024, 1024);
/* 319 */     this.TopJaw.mirror = true;
/* 320 */     setRotation(this.TopJaw, 0.0872665F, 0.0F, 0.0F);
/* 321 */     this.Head = new ModelRenderer(this, 0, 808);
/* 322 */     this.Head.addBox(-17.0F, -18.0F, -40.0F, 34, 36, 40);
/* 323 */     this.Head.setRotationPoint(0.0F, -156.0F, -98.0F);
/* 324 */     this.Head.setTextureSize(1024, 1024);
/* 325 */     this.Head.mirror = true;
/* 326 */     setRotation(this.Head, 0.0872665F, 0.0F, 0.0F);
/* 327 */     this.BodyTop = new ModelRenderer(this, 0, 0);
/* 328 */     this.BodyTop.addBox(-36.0F, -32.0F, -32.0F, 72, 40, 64);
/* 329 */     this.BodyTop.setRotationPoint(0.0F, -126.0F, -50.0F);
/* 330 */     this.BodyTop.setTextureSize(1024, 1024);
/* 331 */     this.BodyTop.mirror = true;
/* 332 */     setRotation(this.BodyTop, 1.308997F, 0.0F, 0.0F);
/* 333 */     this.RShoulder = new ModelRenderer(this, 304, 96);
/* 334 */     this.RShoulder.addBox(-16.0F, -32.0F, -32.0F, 16, 42, 46);
/* 335 */     this.RShoulder.setRotationPoint(-36.0F, -130.0F, -42.0F);
/* 336 */     this.RShoulder.setTextureSize(1024, 1024);
/* 337 */     this.RShoulder.mirror = true;
/* 338 */     setRotation(this.RShoulder, 1.308997F, 0.0F, 0.0F);
/* 339 */     this.RThumbTip = new ModelRenderer(this, 422, 18);
/* 340 */     this.RThumbTip.addBox(5.0F, 1.0F, -43.0F, 8, 8, 12);
/* 341 */     this.RThumbTip.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 342 */     this.RThumbTip.setTextureSize(1024, 1024);
/* 343 */     this.RThumbTip.mirror = true;
/* 344 */     setRotation(this.RThumbTip, 0.0F, 0.0F, 0.0F);
/* 345 */     this.RUpperArm = new ModelRenderer(this, 304, 184);
/* 346 */     this.RUpperArm.addBox(-54.0F, -13.0F, -13.0F, 54, 26, 26);
/* 347 */     this.RUpperArm.setRotationPoint(-38.0F, -130.0F, -52.0F);
/* 348 */     this.RUpperArm.setTextureSize(1024, 1024);
/* 349 */     this.RUpperArm.mirror = true;
/* 350 */     setRotation(this.RUpperArm, 0.0F, -0.2617994F, -0.3490659F);
/* 351 */     this.RHand = new ModelRenderer(this, 245, 292);
/* 352 */     this.RHand.addBox(-13.0F, -13.0F, -13.0F, 26, 26, 26);
/* 353 */     this.RHand.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 354 */     this.RHand.setTextureSize(1024, 1024);
/* 355 */     this.RHand.mirror = true;
/* 356 */     setRotation(this.RHand, -1.071467F, 2.007129F, 0.1745329F);
/* 357 */     this.RThumbBase = new ModelRenderer(this, 424, 57);
/* 358 */     this.RThumbBase.addBox(2.0F, 1.0F, -32.0F, 8, 8, 20);
/* 359 */     this.RThumbBase.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 360 */     this.RThumbBase.setTextureSize(1024, 1024);
/* 361 */     this.RThumbBase.mirror = true;
/* 362 */     setRotation(this.RThumbBase, 0.0F, -0.1047198F, 0.0F);
/* 363 */     this.R3rdFingerTip = new ModelRenderer(this, 422, 18);
/* 364 */     this.R3rdFingerTip.addBox(-10.0F, 0.0F, -41.0F, 8, 8, 12);
/* 365 */     this.R3rdFingerTip.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 366 */     this.R3rdFingerTip.setTextureSize(1024, 1024);
/* 367 */     this.R3rdFingerTip.mirror = true;
/* 368 */     setRotation(this.R3rdFingerTip, 0.0F, 0.6806784F, 0.0F);
/* 369 */     this.R3rdFingerBase = new ModelRenderer(this, 424, 57);
/* 370 */     this.R3rdFingerBase.addBox(-11.0F, -3.0F, -30.0F, 8, 8, 20);
/* 371 */     this.R3rdFingerBase.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 372 */     this.R3rdFingerBase.setTextureSize(1024, 1024);
/* 373 */     this.R3rdFingerBase.mirror = true;
/* 374 */     setRotation(this.R3rdFingerBase, 0.122173F, 0.6457718F, 0.0F);
/* 375 */     this.RIndexTip = new ModelRenderer(this, 422, 18);
/* 376 */     this.RIndexTip.addBox(-4.0F, -12.0F, -43.0F, 8, 8, 12);
/* 377 */     this.RIndexTip.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 378 */     this.RIndexTip.setTextureSize(1024, 1024);
/* 379 */     this.RIndexTip.mirror = true;
/* 380 */     setRotation(this.RIndexTip, -0.2094395F, 0.1745329F, 0.0F);
/* 381 */     this.RIndexBase = new ModelRenderer(this, 424, 57);
/* 382 */     this.RIndexBase.addBox(-4.0F, -9.0F, -34.0F, 8, 8, 20);
/* 383 */     this.RIndexBase.setRotationPoint(-115.0F, -100.0F, -99.0F);
/* 384 */     this.RIndexBase.setTextureSize(1024, 1024);
/* 385 */     this.RIndexBase.mirror = true;
/* 386 */     setRotation(this.RIndexBase, -0.2792527F, 0.1570796F, 0.0F);
/* 387 */     this.LShoulder = new ModelRenderer(this, 304, 96);
/* 388 */     this.LShoulder.addBox(0.0F, -32.0F, -32.0F, 16, 42, 46);
/* 389 */     this.LShoulder.setRotationPoint(36.0F, -130.0F, -42.0F);
/* 390 */     this.LShoulder.setTextureSize(1024, 1024);
/* 391 */     this.LShoulder.mirror = true;
/* 392 */     setRotation(this.LShoulder, 1.308997F, 0.0F, 0.0F);
/* 393 */     this.LUpperArm = new ModelRenderer(this, 304, 184);
/* 394 */     this.LUpperArm.addBox(0.0F, -13.0F, -13.0F, 54, 26, 26);
/* 395 */     this.LUpperArm.setRotationPoint(38.0F, -130.0F, -52.0F);
/* 396 */     this.LUpperArm.setTextureSize(1024, 1024);
/* 397 */     this.LUpperArm.mirror = true;
/* 398 */     setRotation(this.LUpperArm, 0.0F, 0.296706F, 0.3490659F);
/* 399 */     this.LLowerArm = new ModelRenderer(this, 245, 240);
/* 400 */     this.LLowerArm.addBox(0.0F, -11.0F, -11.0F, 48, 22, 22);
/* 401 */     this.LLowerArm.setRotationPoint(80.0F, -115.0F, -61.0F);
/* 402 */     this.LLowerArm.setTextureSize(1024, 1024);
/* 403 */     this.LLowerArm.mirror = true;
/* 404 */     setRotation(this.LLowerArm, 0.0F, 0.7853982F, 0.2617994F);
/* 405 */     this.LIndexBase = new ModelRenderer(this, 424, 57);
/* 406 */     this.LIndexBase.addBox(-4.0F, -13.0F, -32.0F, 8, 8, 20);
/* 407 */     this.LIndexBase.setRotationPoint(115.0F, -100.0F, -99.0F);
/* 408 */     this.LIndexBase.setTextureSize(1024, 1024);
/* 409 */     this.LIndexBase.mirror = true;
/* 410 */     setRotation(this.LIndexBase, -0.1570796F, -0.1396263F, 0.0F);
/* 411 */     this.LIndexTip = new ModelRenderer(this, 422, 18);
/* 412 */     this.LIndexTip.addBox(-1.0F, -18.0F, -41.0F, 8, 8, 12);
/* 413 */     this.LIndexTip.setRotationPoint(115.0F, -100.0F, -99.0F);
/* 414 */     this.LIndexTip.setTextureSize(1024, 1024);
/* 415 */     this.LIndexTip.mirror = true;
/* 416 */     setRotation(this.LIndexTip, 0.0F, -0.0349066F, 0.0F);
/* 417 */     this.LHand = new ModelRenderer(this, 245, 292);
/* 418 */     this.LHand.addBox(-13.0F, -13.0F, -13.0F, 26, 26, 26);
/* 419 */     this.LHand.setRotationPoint(115.0F, -100.0F, -99.0F);
/* 420 */     this.LHand.setTextureSize(1024, 1024);
/* 421 */     this.LHand.mirror = true;
/* 422 */     setRotation(this.LHand, 0.9599311F, 1.308997F, 0.1745329F);
/* 423 */     this.LThumbBase = new ModelRenderer(this, 424, 57);
/* 424 */     this.LThumbBase.addBox(-8.0F, -2.0F, -32.0F, 8, 8, 20);
/* 425 */     this.LThumbBase.setRotationPoint(115.0F, -100.0F, -98.0F);
/* 426 */     this.LThumbBase.setTextureSize(1024, 1024);
/* 427 */     this.LThumbBase.mirror = true;
/* 428 */     setRotation(this.LThumbBase, 0.1396263F, 0.2617994F, 0.0F);
/* 429 */     this.LThumbTip = new ModelRenderer(this, 422, 18);
/* 430 */     this.LThumbTip.addBox(-12.0F, 2.0F, -40.0F, 8, 8, 12);
/* 431 */     this.LThumbTip.setRotationPoint(115.0F, -100.0F, -99.0F);
/* 432 */     this.LThumbTip.setTextureSize(1024, 1024);
/* 433 */     this.LThumbTip.mirror = true;
/* 434 */     setRotation(this.LThumbTip, 0.0F, 0.1396263F, 0.0F);
/* 435 */     this.L3rdFingerTip = new ModelRenderer(this, 422, 18);
/* 436 */     this.L3rdFingerTip.addBox(9.0F, 2.0F, -42.0F, 8, 8, 12);
/* 437 */     this.L3rdFingerTip.setRotationPoint(115.0F, -100.0F, -99.0F);
/* 438 */     this.L3rdFingerTip.setTextureSize(1024, 1024);
/* 439 */     this.L3rdFingerTip.mirror = true;
/* 440 */     setRotation(this.L3rdFingerTip, 0.0349066F, -0.3316126F, 0.0F);
/* 441 */     this.L3rdFingerBase = new ModelRenderer(this, 424, 57);
/* 442 */     this.L3rdFingerBase.addBox(4.0F, -5.0F, -33.0F, 8, 8, 20);
/* 443 */     this.L3rdFingerBase.setRotationPoint(115.0F, -100.0F, -99.0F);
/* 444 */     this.L3rdFingerBase.setTextureSize(1024, 1024);
/* 445 */     this.L3rdFingerBase.mirror = true;
/* 446 */     setRotation(this.L3rdFingerBase, 0.2617994F, -0.4712389F, 0.0F);
/* 447 */     this.Lspikes1 = new ModelRenderer(this, 500, 0);
/* 448 */     this.Lspikes1.addBox(0.0F, -10.0F, 0.0F, 0, 10, 11);
/* 449 */     this.Lspikes1.setRotationPoint(5.0F, -168.0F, -86.0F);
/* 450 */     this.Lspikes1.setTextureSize(1024, 1024);
/* 451 */     this.Lspikes1.mirror = true;
/* 452 */     setRotation(this.Lspikes1, -0.0872665F, 0.0F, -0.0174533F);
/* 453 */     this.Rspikes1 = new ModelRenderer(this, 500, 0);
/* 454 */     this.Rspikes1.addBox(0.0F, -10.0F, 0.0F, 0, 10, 11);
/* 455 */     this.Rspikes1.setRotationPoint(-5.0F, -168.0F, -86.0F);
/* 456 */     this.Rspikes1.setTextureSize(1024, 1024);
/* 457 */     this.Rspikes1.mirror = true;
/* 458 */     setRotation(this.Rspikes1, -0.0872665F, 0.0F, -0.0174533F);
/* 459 */     this.Lspike2 = new ModelRenderer(this, 500, 30);
/* 460 */     this.Lspike2.addBox(0.0F, -25.0F, 0.0F, 0, 25, 21);
/* 461 */     this.Lspike2.setRotationPoint(10.0F, -162.0F, -63.0F);
/* 462 */     this.Lspike2.setTextureSize(1024, 1024);
/* 463 */     this.Lspike2.mirror = true;
/* 464 */     setRotation(this.Lspike2, -0.2617994F, 0.0F, -0.0174533F);
/* 465 */     this.Rspike2 = new ModelRenderer(this, 500, 30);
/* 466 */     this.Rspike2.addBox(0.0F, -25.0F, 0.0F, 0, 25, 21);
/* 467 */     this.Rspike2.setRotationPoint(-10.0F, -162.0F, -63.0F);
/* 468 */     this.Rspike2.setTextureSize(1024, 1024);
/* 469 */     this.Rspike2.mirror = true;
/* 470 */     setRotation(this.Rspike2, -0.2617994F, 0.0F, -0.0174533F);
/* 471 */     this.Lspike3 = new ModelRenderer(this, 500, 80);
/* 472 */     this.Lspike3.addBox(0.0F, -45.0F, 0.0F, 0, 45, 34);
/* 473 */     this.Lspike3.setRotationPoint(14.0F, -153.0F, -32.0F);
/* 474 */     this.Lspike3.setTextureSize(1024, 1024);
/* 475 */     this.Lspike3.mirror = true;
/* 476 */     setRotation(this.Lspike3, -0.4363323F, 0.0F, -0.0174533F);
/* 477 */     this.Rspike3 = new ModelRenderer(this, 500, 80);
/* 478 */     this.Rspike3.addBox(0.0F, -45.0F, 0.0F, 0, 45, 34);
/* 479 */     this.Rspike3.setRotationPoint(-14.0F, -153.0F, -32.0F);
/* 480 */     this.Rspike3.setTextureSize(1024, 1024);
/* 481 */     this.Rspike3.mirror = true;
/* 482 */     setRotation(this.Rspike3, -0.4363323F, 0.0F, -0.0174533F);
/* 483 */     this.Lspike4 = new ModelRenderer(this, 500, 165);
/* 484 */     this.Lspike4.addBox(0.0F, -50.0F, 0.0F, 0, 50, 36);
/* 485 */     this.Lspike4.setRotationPoint(18.0F, -131.0F, 13.0F);
/* 486 */     this.Lspike4.setTextureSize(1024, 1024);
/* 487 */     this.Lspike4.mirror = true;
/* 488 */     setRotation(this.Lspike4, -0.715585F, 0.0F, -0.0174533F);
/* 489 */     this.Rspike4 = new ModelRenderer(this, 500, 165);
/* 490 */     this.Rspike4.addBox(0.0F, -50.0F, 0.0F, 0, 50, 36);
/* 491 */     this.Rspike4.setRotationPoint(-18.0F, -131.0F, 13.0F);
/* 492 */     this.Rspike4.setTextureSize(1024, 1024);
/* 493 */     this.Rspike4.mirror = true;
/* 494 */     setRotation(this.Rspike4, -0.715585F, 0.0F, -0.0174533F);
/* 495 */     this.Lspike5 = new ModelRenderer(this, 500, 255);
/* 496 */     this.Lspike5.addBox(12.0F, -67.0F, 5.0F, 0, 39, 27);
/* 497 */     this.Lspike5.setRotationPoint(0.0F, -73.0F, 26.0F);
/* 498 */     this.Lspike5.setTextureSize(1024, 1024);
/* 499 */     this.Lspike5.mirror = true;
/* 500 */     setRotation(this.Lspike5, -0.7853982F, 0.0F, -0.0174533F);
/* 501 */     this.Rspike5 = new ModelRenderer(this, 500, 255);
/* 502 */     this.Rspike5.addBox(-12.0F, -67.0F, 5.0F, 0, 39, 27);
/* 503 */     this.Rspike5.setRotationPoint(0.0F, -73.0F, 26.0F);
/* 504 */     this.Rspike5.setTextureSize(1024, 1024);
/* 505 */     this.Rspike5.mirror = true;
/* 506 */     setRotation(this.Rspike5, -0.7853982F, 0.0F, -0.0174533F);
/* 507 */     this.Spike6 = new ModelRenderer(this, 500, 325);
/* 508 */     this.Spike6.addBox(0.0F, -48.0F, 11.0F, 0, 25, 21);
/* 509 */     this.Spike6.setRotationPoint(0.0F, -48.0F, 48.0F);
/* 510 */     this.Spike6.setTextureSize(1024, 1024);
/* 511 */     this.Spike6.mirror = true;
/* 512 */     setRotation(this.Spike6, -0.8901179F, 0.0F, -0.0174533F);
/* 513 */     this.Spikes7 = new ModelRenderer(this, 500, 376);
/* 514 */     this.Spikes7.addBox(0.0F, -29.0F, 20.0F, 0, 10, 11);
/* 515 */     this.Spikes7.setRotationPoint(0.0F, -24.0F, 66.0F);
/* 516 */     this.Spikes7.setTextureSize(1024, 1024);
/* 517 */     this.Spikes7.mirror = true;
/* 518 */     setRotation(this.Spikes7, -0.7504916F, 0.0F, -0.0174533F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 525 */     Godzilla e = (Godzilla)entity;
/* 526 */     RenderInfo r = null;
/* 527 */     float newangle = 0.0F;
/* 528 */     float newangle2 = 0.0F;
/* 529 */     float pscale = 1.0F;
/*     */ 
/*     */     
/* 532 */     float pi4 = 0.7853982F;
/* 533 */     float clawZ = 6.0F;
/* 534 */     float clawY = 16.0F;
/* 535 */     float clawZamp = 35.0F * pscale;
/* 536 */     float clawYamp = 18.0F * pscale;
/* 537 */     float spikeamp = 1.0F;
/* 538 */     float spikefreq = 1.0F;
/*     */     
/* 540 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 541 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */     
/* 545 */     r = e.getRenderInfo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 552 */     float t1 = 0.0F;
/* 553 */     float t2 = 0.0F;
/* 554 */     if (f1 > 0.001D) {
/* 555 */       newangle = MathHelper.cos(f2 * 0.75F * this.wingspeed / pscale);
/* 556 */       newangle2 = MathHelper.cos(f2 * 0.75F * this.wingspeed / pscale + pi4);
/* 557 */       t1 = MathHelper.sin(f2 * 0.75F * this.wingspeed / pscale);
/*     */     } else {
/* 559 */       newangle = newangle2 = 0.0F;
/* 560 */       t1 = 0.0F;
/* 561 */       t2 = 0.0F;
/*     */     } 
/* 563 */     if (t1 > 0.0F) {
/* 564 */       t2 = t1 * clawYamp * f1;
/* 565 */       this.LToe1.rotationPointY = clawY - t2;
/*     */     } else {
/* 567 */       this.LToe1.rotationPointY = clawY;
/*     */     } 
/*     */     
/* 570 */     this.LToe1.rotationPointZ = clawZ + clawZamp * newangle * f1;
/* 571 */     this.LToe9.rotationPointZ = this.LToe1.rotationPointZ;
/* 572 */     this.LToe9.rotationPointY = this.LToe1.rotationPointY;
/*     */     
/* 574 */     this.LLowerLeg.rotationPointZ = this.LToe1.rotationPointZ;
/* 575 */     this.LLowerLeg.rotationPointY = this.LToe1.rotationPointY;
/* 576 */     this.LLowerLeg.rotateAngleX = 0.22F + newangle * 3.1415927F * 0.09F * f1;
/*     */     
/* 578 */     this.LUpperLeg.rotateAngleX = -0.17F + newangle2 * 3.1415927F * 0.15F * f1;
/* 579 */     this.LLowerLeg.rotationPointY -= (float)Math.cos(this.LLowerLeg.rotateAngleX) * 55.0F;
/* 580 */     this.LLowerLeg.rotationPointZ -= (float)Math.sin(this.LLowerLeg.rotateAngleX) * 55.0F;
/*     */     
/* 582 */     this.LThigh.rotateAngleX = -0.558F + newangle2 * 3.1415927F * 0.1F * f1;
/* 583 */     this.LThigh.rotationPointZ = 2.0F + clawZamp * newangle * f1 / 4.0F;
/*     */     
/* 585 */     t1 = 0.0F;
/* 586 */     t2 = 0.0F;
/* 587 */     if (f1 > 0.001D) {
/* 588 */       newangle = MathHelper.cos(f2 * 0.75F * this.wingspeed / pscale + pi4 * 4.0F);
/* 589 */       newangle2 = MathHelper.cos(f2 * 0.75F * this.wingspeed / pscale + pi4 * 5.0F);
/* 590 */       t1 = MathHelper.sin(f2 * 0.75F * this.wingspeed / pscale + pi4 * 4.0F);
/*     */     } else {
/* 592 */       newangle = 0.0F;
/* 593 */       t1 = 0.0F;
/* 594 */       t2 = 0.0F;
/*     */     } 
/* 596 */     if (t1 > 0.0F) {
/* 597 */       t2 = t1 * clawYamp * f1;
/* 598 */       this.RToe1.rotationPointY = clawY - t2;
/*     */     } else {
/* 600 */       this.RToe1.rotationPointY = clawY;
/*     */     } 
/* 602 */     this.RToe1.rotationPointZ = clawZ + clawZamp * newangle * f1;
/* 603 */     this.RToe9.rotationPointZ = this.RToe1.rotationPointZ;
/* 604 */     this.RToe9.rotationPointY = this.RToe1.rotationPointY;
/*     */     
/* 606 */     this.RLegLower.rotationPointZ = this.RToe1.rotationPointZ;
/* 607 */     this.RLegLower.rotationPointY = this.RToe1.rotationPointY;
/* 608 */     this.RLegLower.rotateAngleX = 0.22F + newangle * 3.1415927F * 0.09F * f1;
/*     */ 
/*     */     
/* 611 */     this.RLegUpper.rotateAngleX = -0.17F + newangle2 * 3.1415927F * 0.15F * f1;
/* 612 */     this.RLegLower.rotationPointY -= (float)Math.cos(this.RLegLower.rotateAngleX) * 55.0F;
/* 613 */     this.RLegLower.rotationPointZ -= (float)Math.sin(this.RLegLower.rotateAngleX) * 55.0F;
/*     */     
/* 615 */     this.RThigh.rotateAngleX = -0.558F + newangle2 * 3.1415927F * 0.1F * f1;
/* 616 */     this.RThigh.rotationPointZ = 2.0F + clawZamp * newangle * f1 / 4.0F;
/*     */     
/* 618 */     this.LToe1.rotateAngleX = 0.0F;
/* 619 */     this.RToe1.rotateAngleX = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 626 */     if (e.getAttacking() != 0) {
/* 627 */       newangle = MathHelper.cos(f2 * this.wingspeed * 1.75F) * 3.1415927F * 0.2F;
/*     */     } else {
/* 629 */       newangle = MathHelper.cos(f2 * this.wingspeed * 0.75F) * 3.1415927F * 0.05F;
/*     */     } 
/* 631 */     doTail(newangle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 665 */     newangle = (float)Math.toRadians(f3) * 0.55F;
/* 666 */     this.Head.rotateAngleY = newangle;
/* 667 */     this.TopJaw.rotateAngleY = newangle;
/* 668 */     this.LowerJaw.rotateAngleY = newangle;
/* 669 */     this.Head.rotationPointZ -= (float)Math.cos(this.Head.rotateAngleY) * 11.0F;
/* 670 */     this.Head.rotationPointX -= (float)Math.sin(this.Head.rotateAngleY) * 11.0F;
/*     */     
/* 672 */     this.Head.rotateAngleX = (float)Math.toRadians(f4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 678 */     newangle = MathHelper.cos(f2 * this.wingspeed * 1.5F) * 3.1415927F * 0.12F;
/* 679 */     float newrf1 = f2 * 1.5F * this.wingspeed % 6.2831855F;
/* 680 */     newrf1 = Math.abs(newrf1);
/*     */     
/* 682 */     if (newrf1 < r.rf2) {
/*     */       
/* 684 */       r.ri2 = 0;
/* 685 */       if (e.getAttacking() == 0)
/* 686 */       { if (e.worldObj.rand.nextInt(20) == 1) r.ri2 |= 0x1;
/*     */          }
/* 688 */       else if (e.worldObj.rand.nextInt(2) == 1) { r.ri2 |= 0x1; }
/*     */     
/*     */     } 
/* 691 */     r.rf2 = newrf1;
/* 692 */     if ((r.ri2 & 0x1) == 0) {
/* 693 */       newangle = 0.0F;
/*     */     }
/*     */ 
/*     */     
/* 697 */     this.LowerJaw.rotateAngleX = 0.52F + newangle + this.TopJaw.rotateAngleX;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 702 */     newangle = newangle2 = MathHelper.sin(f2 * this.wingspeed * 1.75F) * 3.1415927F * 0.16F;
/* 703 */     newrf1 = f2 * 1.75F * this.wingspeed % 6.2831855F;
/* 704 */     newrf1 = Math.abs(newrf1);
/*     */     
/* 706 */     if (newrf1 < r.rf1) {
/*     */       
/* 708 */       r.ri1 = 0;
/* 709 */       if (e.getAttacking() == 0) {
/* 710 */         if (e.worldObj.rand.nextInt(20) == 1) r.ri1 |= 0x1; 
/* 711 */         if (e.worldObj.rand.nextInt(20) == 1) r.ri1 |= 0x2; 
/*     */       } else {
/* 713 */         if (e.worldObj.rand.nextInt(2) == 1) r.ri1 |= 0x1; 
/* 714 */         if (e.worldObj.rand.nextInt(2) == 1) r.ri1 |= 0x2;
/*     */       
/*     */       } 
/*     */     } 
/* 718 */     r.rf1 = newrf1;
/*     */     
/* 720 */     if ((r.ri1 & 0x1) == 0) {
/* 721 */       newangle = 0.0F;
/*     */     }
/* 723 */     if ((r.ri1 & 0x2) == 0) {
/* 724 */       newangle2 = 0.0F;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 729 */     this.LUpperArm.rotateAngleY = 0.65F + newangle;
/* 730 */     this.LLowerArm.rotateAngleY = 0.78F + newangle * 3.0F / 2.0F;
/* 731 */     this.LUpperArm.rotationPointZ -= (float)Math.sin(this.LUpperArm.rotateAngleY) * 50.0F;
/* 732 */     this.LUpperArm.rotationPointX += (float)Math.cos(this.LUpperArm.rotateAngleY) * 50.0F;
/* 733 */     this.LLowerArm.rotationPointY = this.LUpperArm.rotationPointY - (float)Math.sin(this.LUpperArm.rotateAngleY) * 10.0F + 18.0F;
/*     */     
/* 735 */     this.LLowerArm.rotationPointZ -= (float)Math.sin(this.LLowerArm.rotateAngleY) * 45.0F;
/* 736 */     this.LLowerArm.rotationPointX += (float)Math.cos(this.LLowerArm.rotateAngleY) * 45.0F;
/* 737 */     this.LHand.rotationPointY = this.LLowerArm.rotationPointY - (float)Math.sin(this.LLowerArm.rotateAngleY) * 10.0F + 15.0F;
/*     */     
/* 739 */     this.L3rdFingerBase.rotationPointZ = this.LHand.rotationPointZ;
/* 740 */     this.L3rdFingerTip.rotationPointZ = this.LHand.rotationPointZ;
/* 741 */     this.L3rdFingerBase.rotationPointY = this.LHand.rotationPointY;
/* 742 */     this.L3rdFingerTip.rotationPointY = this.LHand.rotationPointY;
/* 743 */     this.L3rdFingerBase.rotationPointX = this.LHand.rotationPointX;
/* 744 */     this.L3rdFingerTip.rotationPointX = this.LHand.rotationPointX;
/*     */     
/* 746 */     this.LHand.rotateAngleY = 1.308F + newangle * 2.0F;
/* 747 */     this.LIndexBase.rotateAngleY = -0.139F + newangle * 2.0F;
/* 748 */     this.LIndexTip.rotateAngleY = -0.034F + newangle * 2.0F;
/*     */     
/* 750 */     this.LThumbBase.rotateAngleY = 0.261F + newangle;
/* 751 */     this.LThumbTip.rotateAngleY = 0.139F + newangle;
/*     */     
/* 753 */     this.L3rdFingerBase.rotateAngleY = -0.471F + newangle * 3.0F;
/* 754 */     this.L3rdFingerTip.rotateAngleY = -0.331F + newangle * 3.0F;
/*     */ 
/*     */     
/* 757 */     this.RUpperArm.rotateAngleY = -0.65F - newangle2;
/* 758 */     this.RLowerArm.rotateAngleY = -0.78F - newangle2 * 3.0F / 2.0F;
/* 759 */     this.RUpperArm.rotationPointZ += (float)Math.sin(this.RUpperArm.rotateAngleY) * 50.0F;
/* 760 */     this.RUpperArm.rotationPointX -= (float)Math.cos(this.RUpperArm.rotateAngleY) * 50.0F;
/* 761 */     this.RLowerArm.rotationPointY = this.RUpperArm.rotationPointY + (float)Math.sin(this.RUpperArm.rotateAngleY) * 10.0F + 18.0F;
/*     */     
/* 763 */     this.RLowerArm.rotationPointZ += (float)Math.sin(this.RLowerArm.rotateAngleY) * 45.0F;
/* 764 */     this.RLowerArm.rotationPointX -= (float)Math.cos(this.RLowerArm.rotateAngleY) * 45.0F;
/* 765 */     this.RHand.rotationPointY = this.RLowerArm.rotationPointY + (float)Math.sin(this.RLowerArm.rotateAngleY) * 10.0F + 15.0F;
/*     */     
/* 767 */     this.R3rdFingerBase.rotationPointZ = this.RHand.rotationPointZ;
/* 768 */     this.R3rdFingerTip.rotationPointZ = this.RHand.rotationPointZ;
/* 769 */     this.R3rdFingerBase.rotationPointY = this.RHand.rotationPointY;
/* 770 */     this.R3rdFingerTip.rotationPointY = this.RHand.rotationPointY;
/* 771 */     this.R3rdFingerBase.rotationPointX = this.RHand.rotationPointX;
/* 772 */     this.R3rdFingerTip.rotationPointX = this.RHand.rotationPointX;
/*     */     
/* 774 */     this.RHand.rotateAngleY = -2.0F - newangle2 * 2.0F;
/* 775 */     this.RIndexBase.rotateAngleY = 0.157F - newangle2 * 2.0F;
/* 776 */     this.RIndexTip.rotateAngleY = 0.174F - newangle2 * 2.0F;
/*     */     
/* 778 */     this.RThumbBase.rotateAngleY = -0.104F - newangle2;
/* 779 */     this.RThumbTip.rotateAngleY = 0.001F - newangle2;
/*     */     
/* 781 */     this.R3rdFingerTip.rotateAngleY = 0.68F - newangle2 * 3.0F;
/* 782 */     this.R3rdFingerBase.rotateAngleY = 0.645F - newangle2 * 3.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 787 */     e.setRenderInfo(r);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 792 */     this.LToe1.render(f5);
/* 793 */     this.LToe3.render(f5);
/* 794 */     this.LToe2.render(f5);
/* 795 */     this.LToe9.render(f5);
/* 796 */     this.LToe8.render(f5);
/* 797 */     this.LToe7.render(f5);
/* 798 */     this.LToe6.render(f5);
/* 799 */     this.LToe5.render(f5);
/* 800 */     this.LToe4.render(f5);
/* 801 */     this.RToe9.render(f5);
/* 802 */     this.RToe6.render(f5);
/* 803 */     this.RToe5.render(f5);
/* 804 */     this.RToe2.render(f5);
/* 805 */     this.RToe1.render(f5);
/* 806 */     this.RToe4.render(f5);
/* 807 */     this.RToe7.render(f5);
/* 808 */     this.RToe8.render(f5);
/* 809 */     this.RToe3.render(f5);
/* 810 */     this.LThigh.render(f5);
/* 811 */     this.LLowerLeg.render(f5);
/* 812 */     this.LUpperLeg.render(f5);
/* 813 */     this.TailTip.render(f5);
/* 814 */     this.RLegLower.render(f5);
/* 815 */     this.RLegUpper.render(f5);
/* 816 */     this.RThigh.render(f5);
/* 817 */     this.LowerJaw.render(f5);
/* 818 */     this.TailBase.render(f5);
/* 819 */     this.Tail2.render(f5);
/* 820 */     this.Tail3.render(f5);
/* 821 */     this.Tail4.render(f5);
/* 822 */     this.Tail5.render(f5);
/* 823 */     this.Tail6.render(f5);
/* 824 */     this.Tail7.render(f5);
/* 825 */     this.BodyBottom.render(f5);
/* 826 */     this.RLowerArm.render(f5);
/* 827 */     this.BodyCenter.render(f5);
/* 828 */     this.Neck.render(f5);
/* 829 */     this.TopJaw.render(f5);
/* 830 */     this.Head.render(f5);
/* 831 */     this.BodyTop.render(f5);
/* 832 */     this.RShoulder.render(f5);
/* 833 */     this.RThumbTip.render(f5);
/* 834 */     this.RUpperArm.render(f5);
/* 835 */     this.RHand.render(f5);
/* 836 */     this.RThumbBase.render(f5);
/* 837 */     this.R3rdFingerTip.render(f5);
/* 838 */     this.R3rdFingerBase.render(f5);
/* 839 */     this.RIndexTip.render(f5);
/* 840 */     this.RIndexBase.render(f5);
/* 841 */     this.LShoulder.render(f5);
/* 842 */     this.LUpperArm.render(f5);
/* 843 */     this.LLowerArm.render(f5);
/* 844 */     this.LIndexBase.render(f5);
/* 845 */     this.LIndexTip.render(f5);
/* 846 */     this.LHand.render(f5);
/* 847 */     this.LThumbBase.render(f5);
/* 848 */     this.LThumbTip.render(f5);
/* 849 */     this.L3rdFingerTip.render(f5);
/* 850 */     this.L3rdFingerBase.render(f5);
/* 851 */     this.Lspikes1.render(f5);
/* 852 */     this.Rspikes1.render(f5);
/* 853 */     this.Lspike2.render(f5);
/* 854 */     this.Rspike2.render(f5);
/* 855 */     this.Lspike3.render(f5);
/* 856 */     this.Rspike3.render(f5);
/* 857 */     this.Lspike4.render(f5);
/* 858 */     this.Rspike4.render(f5);
/* 859 */     this.Lspike5.render(f5);
/* 860 */     this.Rspike5.render(f5);
/* 861 */     this.Spike6.render(f5);
/* 862 */     this.Spikes7.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 868 */     model.rotateAngleX = x;
/* 869 */     model.rotateAngleY = y;
/* 870 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 875 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doTail(float angle) {
/* 880 */     this.TailBase.rotateAngleY = angle * 0.25F;
/* 881 */     this.Rspike5.rotateAngleY = this.TailBase.rotateAngleY;
/*     */     
/* 883 */     this.Tail2.rotateAngleY = angle * 0.5F;
/* 884 */     this.TailBase.rotationPointZ += (float)Math.cos(this.TailBase.rotateAngleY) * 25.0F;
/* 885 */     this.TailBase.rotationPointX += (float)Math.sin(this.TailBase.rotateAngleY) * 25.0F;
/* 886 */     this.Spike6.rotateAngleY = this.Tail2.rotateAngleY;
/* 887 */     this.Spike6.rotationPointZ = this.Tail2.rotationPointZ;
/* 888 */     this.Spike6.rotationPointX = this.Tail2.rotationPointX;
/*     */     
/* 890 */     this.Tail3.rotateAngleY = angle * 0.75F;
/* 891 */     this.Tail2.rotationPointZ += (float)Math.cos(this.Tail2.rotateAngleY) * 20.0F;
/* 892 */     this.Tail2.rotationPointX += (float)Math.sin(this.Tail2.rotateAngleY) * 20.0F;
/* 893 */     this.Spikes7.rotateAngleY = this.Tail3.rotateAngleY;
/* 894 */     this.Spikes7.rotationPointZ = this.Tail3.rotationPointZ;
/* 895 */     this.Spikes7.rotationPointX = this.Tail3.rotationPointX;
/*     */     
/* 897 */     this.Tail4.rotateAngleY = angle * 1.25F;
/* 898 */     this.Tail3.rotationPointZ += (float)Math.cos(this.Tail3.rotateAngleY) * 20.0F;
/* 899 */     this.Tail3.rotationPointX += (float)Math.sin(this.Tail3.rotateAngleY) * 20.0F;
/*     */     
/* 901 */     this.Tail5.rotateAngleY = angle * 1.5F;
/* 902 */     this.Tail4.rotationPointZ += (float)Math.cos(this.Tail4.rotateAngleY) * 25.0F;
/* 903 */     this.Tail4.rotationPointX += (float)Math.sin(this.Tail4.rotateAngleY) * 25.0F;
/*     */     
/* 905 */     this.Tail6.rotateAngleY = angle * 1.75F;
/* 906 */     this.Tail5.rotationPointZ += (float)Math.cos(this.Tail5.rotateAngleY) * 27.0F;
/* 907 */     this.Tail5.rotationPointX += (float)Math.sin(this.Tail5.rotateAngleY) * 27.0F;
/*     */     
/* 909 */     this.Tail7.rotateAngleY = angle * 2.0F;
/* 910 */     this.Tail6.rotationPointZ += (float)Math.cos(this.Tail6.rotateAngleY) * 28.0F;
/* 911 */     this.Tail6.rotationPointX += (float)Math.sin(this.Tail6.rotateAngleY) * 28.0F;
/*     */     
/* 913 */     this.TailTip.rotateAngleY = angle * 2.25F;
/* 914 */     this.Tail7.rotationPointZ += (float)Math.cos(this.Tail7.rotateAngleY) * 18.0F;
/* 915 */     this.Tail7.rotationPointX += (float)Math.sin(this.Tail7.rotateAngleY) * 18.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelGodzilla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */