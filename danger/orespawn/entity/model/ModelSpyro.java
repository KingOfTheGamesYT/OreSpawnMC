/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Spyro;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelSpyro extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer RightFrontPaw;
/*     */   ModelRenderer WingLeft;
/*     */   ModelRenderer LegRightFrontTop;
/*     */   ModelRenderer LegRightFrontBottom;
/*     */   ModelRenderer LegRightBackTop;
/*     */   ModelRenderer LegRightBackBottom;
/*     */   ModelRenderer RightBackPaw;
/*     */   ModelRenderer LegLeftFrontTop;
/*     */   ModelRenderer SnoutRight;
/*     */   ModelRenderer LeftFrontPaw;
/*     */   ModelRenderer LegLeftBackTop;
/*     */   ModelRenderer LegLeftBackBottom;
/*     */   ModelRenderer LeftBackPaw;
/*     */   ModelRenderer LegLeftFrontBottom;
/*     */   ModelRenderer TailPieceSmall;
/*     */   ModelRenderer JawPiece;
/*     */   ModelRenderer HeadPieceBottom;
/*     */   ModelRenderer HeadPieceTop;
/*     */   ModelRenderer HornRightBottom;
/*     */   ModelRenderer HornLeftBottom;
/*     */   ModelRenderer HornRightTop;
/*     */   ModelRenderer HornLeftTop;
/*     */   ModelRenderer Torso;
/*     */   ModelRenderer SnoutLeft;
/*     */   ModelRenderer WingPieceLeft;
/*     */   ModelRenderer WingRight;
/*     */   ModelRenderer WingPieceRight;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer TailBack;
/*     */   ModelRenderer TailFront;
/*     */   ModelRenderer ScaleBackHead;
/*     */   ModelRenderer TailPieceLarge;
/*     */   ModelRenderer ScaleTailPiece;
/*     */   ModelRenderer ScaleHead;
/*     */   ModelRenderer ScaleTop1;
/*     */   ModelRenderer ScaleBackPiece1;
/*     */   ModelRenderer ScaleBackPiece2;
/*     */   
/*     */   public ModelSpyro(float f1) {
/*  51 */     this.wingspeed = f1;
/*     */     
/*  53 */     this.textureWidth = 64;
/*  54 */     this.textureHeight = 64;
/*     */     
/*  56 */     this.RightFrontPaw = new ModelRenderer(this, 12, 31);
/*  57 */     this.RightFrontPaw.addBox(0.0F, 5.0F, -4.0F, 2, 1, 4);
/*  58 */     this.RightFrontPaw.setRotationPoint(3.0F, 18.0F, -2.0F);
/*  59 */     this.RightFrontPaw.setTextureSize(64, 64);
/*  60 */     this.RightFrontPaw.mirror = true;
/*  61 */     setRotation(this.RightFrontPaw, 0.0F, 0.0F, 0.0F);
/*  62 */     this.WingLeft = new ModelRenderer(this, 2, 51);
/*  63 */     this.WingLeft.addBox(-10.0F, -1.0F, -2.0F, 10, 0, 4);
/*  64 */     this.WingLeft.setRotationPoint(-1.0F, 16.0F, 0.0F);
/*  65 */     this.WingLeft.setTextureSize(64, 64);
/*  66 */     this.WingLeft.mirror = true;
/*  67 */     setRotation(this.WingLeft, 0.1745329F, 0.0F, -0.1745329F);
/*  68 */     this.LegRightFrontTop = new ModelRenderer(this, 20, 19);
/*  69 */     this.LegRightFrontTop.addBox(0.0F, 0.0F, -2.0F, 2, 3, 3);
/*  70 */     this.LegRightFrontTop.setRotationPoint(3.0F, 18.0F, -2.0F);
/*  71 */     this.LegRightFrontTop.setTextureSize(64, 64);
/*  72 */     this.LegRightFrontTop.mirror = true;
/*  73 */     setRotation(this.LegRightFrontTop, -0.0872665F, 0.0F, 0.0F);
/*  74 */     this.LegRightFrontBottom = new ModelRenderer(this, 0, 25);
/*  75 */     this.LegRightFrontBottom.addBox(0.0F, 2.0F, -1.5F, 2, 4, 2);
/*  76 */     this.LegRightFrontBottom.setRotationPoint(3.0F, 18.0F, -2.0F);
/*  77 */     this.LegRightFrontBottom.setTextureSize(64, 64);
/*  78 */     this.LegRightFrontBottom.mirror = true;
/*  79 */     setRotation(this.LegRightFrontBottom, -0.1745329F, 0.0F, 0.0F);
/*  80 */     this.LegRightBackTop = new ModelRenderer(this, 30, 19);
/*  81 */     this.LegRightBackTop.addBox(0.0F, 0.0F, -2.0F, 2, 3, 3);
/*  82 */     this.LegRightBackTop.setRotationPoint(3.0F, 18.0F, 3.0F);
/*  83 */     this.LegRightBackTop.setTextureSize(64, 64);
/*  84 */     this.LegRightBackTop.mirror = true;
/*  85 */     setRotation(this.LegRightBackTop, 0.1396263F, 0.0F, 0.0F);
/*  86 */     this.LegRightBackBottom = new ModelRenderer(this, 16, 25);
/*  87 */     this.LegRightBackBottom.addBox(0.0F, 2.0F, -1.0F, 2, 4, 2);
/*  88 */     this.LegRightBackBottom.setRotationPoint(3.0F, 18.0F, 3.0F);
/*  89 */     this.LegRightBackBottom.setTextureSize(64, 64);
/*  90 */     this.LegRightBackBottom.mirror = true;
/*  91 */     setRotation(this.LegRightBackBottom, -0.1745329F, 0.0F, 0.0F);
/*  92 */     this.RightBackPaw = new ModelRenderer(this, 36, 31);
/*  93 */     this.RightBackPaw.addBox(0.0F, 5.0F, -3.0F, 2, 1, 4);
/*  94 */     this.RightBackPaw.setRotationPoint(3.0F, 18.0F, 3.0F);
/*  95 */     this.RightBackPaw.setTextureSize(64, 64);
/*  96 */     this.RightBackPaw.mirror = true;
/*  97 */     setRotation(this.RightBackPaw, 0.0F, 0.0F, 0.0F);
/*  98 */     this.LegLeftFrontTop = new ModelRenderer(this, 0, 19);
/*  99 */     this.LegLeftFrontTop.addBox(-2.0F, 0.0F, -1.0F, 2, 3, 3);
/* 100 */     this.LegLeftFrontTop.setRotationPoint(-2.0F, 18.0F, -3.0F);
/* 101 */     this.LegLeftFrontTop.setTextureSize(64, 64);
/* 102 */     this.LegLeftFrontTop.mirror = true;
/* 103 */     setRotation(this.LegLeftFrontTop, -0.0872665F, 0.0F, 0.0F);
/* 104 */     this.SnoutRight = new ModelRenderer(this, 48, 2);
/* 105 */     this.SnoutRight.addBox(1.0F, -3.0F, -5.0F, 1, 1, 1);
/* 106 */     this.SnoutRight.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 107 */     this.SnoutRight.setTextureSize(64, 64);
/* 108 */     this.SnoutRight.mirror = true;
/* 109 */     setRotation(this.SnoutRight, 0.0F, 0.0F, 0.0F);
/* 110 */     this.LeftFrontPaw = new ModelRenderer(this, 0, 31);
/* 111 */     this.LeftFrontPaw.addBox(-2.0F, 5.0F, -3.0F, 2, 1, 4);
/* 112 */     this.LeftFrontPaw.setRotationPoint(-2.0F, 18.0F, -3.0F);
/* 113 */     this.LeftFrontPaw.setTextureSize(64, 64);
/* 114 */     this.LeftFrontPaw.mirror = true;
/* 115 */     setRotation(this.LeftFrontPaw, 0.0F, 0.0F, 0.0F);
/* 116 */     this.LegLeftBackTop = new ModelRenderer(this, 10, 19);
/* 117 */     this.LegLeftBackTop.addBox(-2.0F, 0.0F, -2.0F, 2, 3, 3);
/* 118 */     this.LegLeftBackTop.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 119 */     this.LegLeftBackTop.setTextureSize(64, 64);
/* 120 */     this.LegLeftBackTop.mirror = true;
/* 121 */     setRotation(this.LegLeftBackTop, 0.1396263F, 0.0F, 0.0F);
/* 122 */     this.LegLeftBackBottom = new ModelRenderer(this, 24, 25);
/* 123 */     this.LegLeftBackBottom.addBox(-2.0F, 2.0F, -1.0F, 2, 4, 2);
/* 124 */     this.LegLeftBackBottom.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 125 */     this.LegLeftBackBottom.setTextureSize(64, 64);
/* 126 */     this.LegLeftBackBottom.mirror = true;
/* 127 */     setRotation(this.LegLeftBackBottom, -0.1745329F, 0.0F, 0.0F);
/* 128 */     this.LeftBackPaw = new ModelRenderer(this, 24, 31);
/* 129 */     this.LeftBackPaw.addBox(-2.0F, 5.0F, -3.0F, 2, 1, 4);
/* 130 */     this.LeftBackPaw.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 131 */     this.LeftBackPaw.setTextureSize(64, 64);
/* 132 */     this.LeftBackPaw.mirror = true;
/* 133 */     setRotation(this.LeftBackPaw, 0.0F, 0.0F, 0.0F);
/* 134 */     this.LegLeftFrontBottom = new ModelRenderer(this, 8, 25);
/* 135 */     this.LegLeftFrontBottom.addBox(-2.0F, 2.0F, -0.5F, 2, 4, 2);
/* 136 */     this.LegLeftFrontBottom.setRotationPoint(-2.0F, 18.0F, -3.0F);
/* 137 */     this.LegLeftFrontBottom.setTextureSize(64, 64);
/* 138 */     this.LegLeftFrontBottom.mirror = true;
/* 139 */     setRotation(this.LegLeftFrontBottom, -0.1745329F, 0.0F, 0.0F);
/* 140 */     this.TailPieceSmall = new ModelRenderer(this, 28, 36);
/* 141 */     this.TailPieceSmall.addBox(0.0F, -0.5F, 4.0F, 1, 1, 1);
/* 142 */     this.TailPieceSmall.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 143 */     this.TailPieceSmall.setTextureSize(64, 64);
/* 144 */     this.TailPieceSmall.mirror = true;
/* 145 */     setRotation(this.TailPieceSmall, 0.1745329F, 0.0F, 0.0F);
/* 146 */     this.JawPiece = new ModelRenderer(this, 52, 0);
/* 147 */     this.JawPiece.addBox(-2.0F, -1.0F, -4.0F, 3, 1, 3);
/* 148 */     this.JawPiece.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 149 */     this.JawPiece.setTextureSize(64, 64);
/* 150 */     this.JawPiece.mirror = true;
/* 151 */     setRotation(this.JawPiece, 0.1745329F, 0.0F, 0.0F);
/* 152 */     this.HeadPieceBottom = new ModelRenderer(this, 30, 7);
/* 153 */     this.HeadPieceBottom.addBox(-3.0F, -2.0F, -5.0F, 5, 2, 6);
/* 154 */     this.HeadPieceBottom.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 155 */     this.HeadPieceBottom.setTextureSize(64, 64);
/* 156 */     this.HeadPieceBottom.mirror = true;
/* 157 */     setRotation(this.HeadPieceBottom, 0.0F, 0.0F, 0.0F);
/* 158 */     this.HeadPieceTop = new ModelRenderer(this, 30, 0);
/* 159 */     this.HeadPieceTop.addBox(-3.0F, -5.0F, -3.0F, 5, 3, 4);
/* 160 */     this.HeadPieceTop.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 161 */     this.HeadPieceTop.setTextureSize(64, 64);
/* 162 */     this.HeadPieceTop.mirror = true;
/* 163 */     setRotation(this.HeadPieceTop, 0.0F, 0.0F, 0.0F);
/* 164 */     this.HornRightBottom = new ModelRenderer(this, 8, 14);
/* 165 */     this.HornRightBottom.addBox(0.0F, -6.0F, -3.5F, 2, 3, 2);
/* 166 */     this.HornRightBottom.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 167 */     this.HornRightBottom.setTextureSize(64, 64);
/* 168 */     this.HornRightBottom.mirror = true;
/* 169 */     setRotation(this.HornRightBottom, -0.7853982F, 0.7853982F, 0.0F);
/* 170 */     this.HornLeftBottom = new ModelRenderer(this, 0, 14);
/* 171 */     this.HornLeftBottom.addBox(-2.75F, -6.5F, -3.0F, 2, 3, 2);
/* 172 */     this.HornLeftBottom.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 173 */     this.HornLeftBottom.setTextureSize(64, 64);
/* 174 */     this.HornLeftBottom.mirror = true;
/* 175 */     setRotation(this.HornLeftBottom, -0.7853982F, -0.7853982F, 0.0F);
/* 176 */     this.HornRightTop = new ModelRenderer(this, 20, 14);
/* 177 */     this.HornRightTop.addBox(0.5F, -9.0F, -3.0F, 1, 3, 1);
/* 178 */     this.HornRightTop.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 179 */     this.HornRightTop.setTextureSize(64, 64);
/* 180 */     this.HornRightTop.mirror = true;
/* 181 */     setRotation(this.HornRightTop, -0.7853982F, 0.7853982F, 0.0F);
/* 182 */     this.HornLeftTop = new ModelRenderer(this, 16, 14);
/* 183 */     this.HornLeftTop.addBox(-2.2F, -9.5F, -2.5F, 1, 3, 1);
/* 184 */     this.HornLeftTop.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 185 */     this.HornLeftTop.setTextureSize(64, 64);
/* 186 */     this.HornLeftTop.mirror = true;
/* 187 */     setRotation(this.HornLeftTop, -0.7853982F, -0.7853982F, 0.0F);
/* 188 */     this.Torso = new ModelRenderer(this, 0, 0);
/* 189 */     this.Torso.addBox(-2.0F, -2.0F, -5.0F, 5, 4, 10);
/* 190 */     this.Torso.setRotationPoint(0.0F, 19.0F, 0.0F);
/* 191 */     this.Torso.setTextureSize(64, 64);
/* 192 */     this.Torso.mirror = true;
/* 193 */     setRotation(this.Torso, 0.0F, 0.0F, 0.0F);
/* 194 */     this.SnoutLeft = new ModelRenderer(this, 48, 0);
/* 195 */     this.SnoutLeft.addBox(-3.0F, -3.0F, -5.0F, 1, 1, 1);
/* 196 */     this.SnoutLeft.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 197 */     this.SnoutLeft.setTextureSize(64, 64);
/* 198 */     this.SnoutLeft.mirror = true;
/* 199 */     setRotation(this.SnoutLeft, 0.0F, 0.0F, 0.0F);
/* 200 */     this.WingPieceLeft = new ModelRenderer(this, 4, 42);
/* 201 */     this.WingPieceLeft.addBox(-1.0F, -2.0F, -1.0F, 1, 2, 1);
/* 202 */     this.WingPieceLeft.setRotationPoint(0.0F, 17.2F, 0.0F);
/* 203 */     this.WingPieceLeft.setTextureSize(64, 64);
/* 204 */     this.WingPieceLeft.mirror = true;
/* 205 */     setRotation(this.WingPieceLeft, 0.1745329F, 0.0F, -0.1745329F);
/* 206 */     this.WingRight = new ModelRenderer(this, 2, 45);
/* 207 */     this.WingRight.addBox(0.0F, -1.0F, -2.0F, 10, 0, 4);
/* 208 */     this.WingRight.setRotationPoint(2.0F, 16.0F, 0.0F);
/* 209 */     this.WingRight.setTextureSize(64, 64);
/* 210 */     this.WingRight.mirror = true;
/* 211 */     setRotation(this.WingRight, 0.1745329F, 0.0F, 0.1745329F);
/* 212 */     this.WingPieceRight = new ModelRenderer(this, 0, 42);
/* 213 */     this.WingPieceRight.addBox(-1.0F, -2.0F, 0.0F, 1, 2, 1);
/* 214 */     this.WingPieceRight.setRotationPoint(2.0F, 17.5F, -1.0F);
/* 215 */     this.WingPieceRight.setTextureSize(64, 64);
/* 216 */     this.WingPieceRight.mirror = true;
/* 217 */     setRotation(this.WingPieceRight, 0.1745329F, 0.0F, 0.1745329F);
/* 218 */     this.Neck = new ModelRenderer(this, 52, 7);
/* 219 */     this.Neck.addBox(-1.0F, -2.0F, -1.0F, 3, 3, 3);
/* 220 */     this.Neck.setRotationPoint(0.0F, 17.0F, -4.0F);
/* 221 */     this.Neck.setTextureSize(64, 64);
/* 222 */     this.Neck.mirror = true;
/* 223 */     setRotation(this.Neck, 0.4537856F, 0.0F, 0.0F);
/* 224 */     this.TailBack = new ModelRenderer(this, 0, 36);
/* 225 */     this.TailBack.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4);
/* 226 */     this.TailBack.setRotationPoint(0.5F, 17.5F, 5.0F);
/* 227 */     this.TailBack.setTextureSize(64, 64);
/* 228 */     this.TailBack.mirror = true;
/* 229 */     setRotation(this.TailBack, 0.4537856F, 0.0F, 0.0F);
/* 230 */     this.TailFront = new ModelRenderer(this, 12, 36);
/* 231 */     this.TailFront.addBox(0.0F, 0.0F, -1.0F, 1, 1, 4);
/* 232 */     this.TailFront.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 233 */     this.TailFront.setTextureSize(64, 64);
/* 234 */     this.TailFront.mirror = true;
/* 235 */     setRotation(this.TailFront, 0.2617994F, 0.0F, 0.0F);
/* 236 */     this.ScaleBackHead = new ModelRenderer(this, 38, 36);
/* 237 */     this.ScaleBackHead.addBox(-1.0F, -3.0F, 2.0F, 1, 2, 1);
/* 238 */     this.ScaleBackHead.setRotationPoint(1.0F, 16.0F, -4.0F);
/* 239 */     this.ScaleBackHead.setTextureSize(64, 64);
/* 240 */     this.ScaleBackHead.mirror = true;
/* 241 */     setRotation(this.ScaleBackHead, 0.0F, 0.0F, 0.0F);
/* 242 */     this.TailPieceLarge = new ModelRenderer(this, 22, 36);
/* 243 */     this.TailPieceLarge.addBox(0.0F, -1.0F, 2.0F, 1, 2, 2);
/* 244 */     this.TailPieceLarge.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 245 */     this.TailPieceLarge.setTextureSize(64, 64);
/* 246 */     this.TailPieceLarge.mirror = true;
/* 247 */     setRotation(this.TailPieceLarge, 0.1745329F, 0.0F, 0.0F);
/* 248 */     this.ScaleTailPiece = new ModelRenderer(this, 48, 36);
/* 249 */     this.ScaleTailPiece.addBox(-0.5F, -2.0F, 0.2F, 1, 1, 2);
/* 250 */     this.ScaleTailPiece.setRotationPoint(0.5F, 17.5F, 5.0F);
/* 251 */     this.ScaleTailPiece.setTextureSize(64, 64);
/* 252 */     this.ScaleTailPiece.mirror = true;
/* 253 */     setRotation(this.ScaleTailPiece, 0.4537856F, 0.0F, 0.0F);
/* 254 */     this.ScaleHead = new ModelRenderer(this, 42, 36);
/* 255 */     this.ScaleHead.addBox(-1.0F, -6.0F, 0.0F, 1, 2, 2);
/* 256 */     this.ScaleHead.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 257 */     this.ScaleHead.setTextureSize(64, 64);
/* 258 */     this.ScaleHead.mirror = true;
/* 259 */     setRotation(this.ScaleHead, 0.0F, 0.0F, 0.0F);
/* 260 */     this.ScaleTop1 = new ModelRenderer(this, 48, 36);
/* 261 */     this.ScaleTop1.addBox(-1.0F, -6.0F, -4.0F, 1, 1, 2);
/* 262 */     this.ScaleTop1.setRotationPoint(1.0F, 16.0F, -2.0F);
/* 263 */     this.ScaleTop1.setTextureSize(64, 64);
/* 264 */     this.ScaleTop1.mirror = true;
/* 265 */     setRotation(this.ScaleTop1, 0.0F, 0.0F, 0.0F);
/* 266 */     this.ScaleBackPiece1 = new ModelRenderer(this, 48, 36);
/* 267 */     this.ScaleBackPiece1.addBox(0.0F, -1.0F, -1.0F, 1, 1, 2);
/* 268 */     this.ScaleBackPiece1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 269 */     this.ScaleBackPiece1.setTextureSize(64, 64);
/* 270 */     this.ScaleBackPiece1.mirror = true;
/* 271 */     setRotation(this.ScaleBackPiece1, 0.0F, 0.0F, 0.0F);
/* 272 */     this.ScaleBackPiece2 = new ModelRenderer(this, 48, 36);
/* 273 */     this.ScaleBackPiece2.addBox(0.0F, -1.0F, -1.0F, 1, 1, 2);
/* 274 */     this.ScaleBackPiece2.setRotationPoint(0.0F, 17.0F, 3.0F);
/* 275 */     this.ScaleBackPiece2.setTextureSize(64, 64);
/* 276 */     this.ScaleBackPiece2.mirror = true;
/* 277 */     setRotation(this.ScaleBackPiece2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 285 */     Spyro c = (Spyro)entity;
/* 286 */     float hf = 0.0F;
/* 287 */     float newangle = 0.0F;
/*     */     
/* 289 */     int current_activity = c.getActivity();
/*     */     
/* 291 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 292 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     if (f1 > 0.1D) {
/* 298 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/*     */     } else {
/* 300 */       newangle = 0.0F;
/*     */     } 
/* 302 */     if (current_activity == 3) {
/* 303 */       newangle *= 0.5F;
/*     */     }
/* 305 */     this.WingLeft.rotateAngleZ = newangle;
/* 306 */     this.WingRight.rotateAngleZ = -newangle;
/*     */ 
/*     */ 
/*     */     
/* 310 */     if (f1 > 0.1D) {
/* 311 */       newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 313 */       newangle = 0.0F;
/*     */     } 
/* 315 */     if (current_activity == 3) newangle = 0.0F;
/*     */     
/* 317 */     if (current_activity != 2) {
/* 318 */       this.LegRightFrontTop.rotateAngleX = newangle - 0.087F;
/* 319 */       this.LegRightFrontBottom.rotateAngleX = newangle - 0.17F;
/* 320 */       this.RightFrontPaw.rotateAngleX = newangle;
/*     */       
/* 322 */       this.LegLeftFrontTop.rotateAngleX = -newangle - 0.087F;
/* 323 */       this.LegLeftFrontBottom.rotateAngleX = -newangle - 0.17F;
/* 324 */       this.LeftFrontPaw.rotateAngleX = -newangle;
/*     */       
/* 326 */       this.LegRightBackBottom.rotateAngleX = -newangle + 0.139F;
/* 327 */       this.LegRightBackTop.rotateAngleX = -newangle - 0.174F;
/* 328 */       this.RightBackPaw.rotateAngleX = -newangle;
/*     */       
/* 330 */       this.LegLeftBackBottom.rotateAngleX = newangle + 0.139F;
/* 331 */       this.LegLeftBackTop.rotateAngleX = newangle - 0.174F;
/* 332 */       this.LeftBackPaw.rotateAngleX = newangle;
/*     */     } else {
/*     */       
/* 335 */       newangle = -1.0F;
/* 336 */       this.LegRightFrontTop.rotateAngleX = newangle - 0.087F;
/* 337 */       this.LegRightFrontBottom.rotateAngleX = newangle - 0.17F;
/* 338 */       this.RightFrontPaw.rotateAngleX = newangle;
/* 339 */       this.LegLeftFrontTop.rotateAngleX = newangle - 0.087F;
/* 340 */       this.LegLeftFrontBottom.rotateAngleX = newangle - 0.17F;
/* 341 */       this.LeftFrontPaw.rotateAngleX = newangle;
/*     */       
/* 343 */       newangle = 1.0F;
/* 344 */       this.LegRightBackBottom.rotateAngleX = newangle + 0.139F;
/* 345 */       this.LegRightBackTop.rotateAngleX = newangle - 0.174F;
/* 346 */       this.RightBackPaw.rotateAngleX = newangle;
/* 347 */       this.LegLeftBackBottom.rotateAngleX = newangle + 0.139F;
/* 348 */       this.LegLeftBackTop.rotateAngleX = newangle - 0.174F;
/* 349 */       this.LeftBackPaw.rotateAngleX = newangle;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 354 */     newangle = MathHelper.cos(f2 * 1.2F * this.wingspeed) * 3.1415927F * 0.25F;
/* 355 */     if (c.isSitting() == true || current_activity == 3) {
/* 356 */       newangle = 0.0F;
/*     */     }
/* 358 */     this.TailBack.rotateAngleY = newangle;
/* 359 */     this.ScaleTailPiece.rotateAngleY = newangle;
/*     */     
/* 361 */     this.TailBack.rotationPointZ += (float)Math.cos(this.TailBack.rotateAngleY) * 3.0F;
/* 362 */     this.TailFront.rotationPointX = this.TailBack.rotationPointX + (float)Math.sin(this.TailBack.rotateAngleY) * 3.0F - 0.5F;
/* 363 */     this.TailFront.rotateAngleY = newangle * 1.6F;
/* 364 */     this.TailPieceLarge.rotationPointZ = this.TailFront.rotationPointZ;
/* 365 */     this.TailPieceLarge.rotationPointX = this.TailFront.rotationPointX;
/* 366 */     this.TailPieceLarge.rotateAngleY = this.TailFront.rotateAngleY;
/* 367 */     this.TailPieceSmall.rotationPointZ = this.TailFront.rotationPointZ;
/* 368 */     this.TailPieceSmall.rotationPointX = this.TailFront.rotationPointX;
/* 369 */     this.TailPieceSmall.rotateAngleY = this.TailFront.rotateAngleY;
/*     */ 
/*     */ 
/*     */     
/* 373 */     this.HeadPieceTop.rotateAngleY = (float)Math.toRadians(f3);
/* 374 */     this.HeadPieceBottom.rotateAngleY = (float)Math.toRadians(f3);
/* 375 */     this.JawPiece.rotateAngleY = (float)Math.toRadians(f3);
/* 376 */     this.SnoutRight.rotateAngleY = (float)Math.toRadians(f3);
/* 377 */     this.SnoutLeft.rotateAngleY = (float)Math.toRadians(f3);
/* 378 */     this.ScaleTop1.rotateAngleY = (float)Math.toRadians(f3);
/* 379 */     this.ScaleHead.rotateAngleY = (float)Math.toRadians(f3);
/* 380 */     this.ScaleBackHead.rotateAngleY = (float)Math.toRadians(f3);
/* 381 */     this.HornRightBottom.rotateAngleY = (float)Math.toRadians(f3) + 0.785F;
/* 382 */     this.HornRightTop.rotateAngleY = (float)Math.toRadians(f3) + 0.785F;
/* 383 */     this.HornLeftBottom.rotateAngleY = (float)Math.toRadians(f3) - 0.785F;
/* 384 */     this.HornLeftTop.rotateAngleY = (float)Math.toRadians(f3) - 0.785F;
/*     */ 
/*     */     
/* 387 */     this.HeadPieceTop.rotateAngleX = (float)Math.toRadians(f4);
/* 388 */     this.HeadPieceBottom.rotateAngleX = (float)Math.toRadians(f4);
/* 389 */     this.JawPiece.rotateAngleX = (float)Math.toRadians(f4);
/* 390 */     this.SnoutRight.rotateAngleX = (float)Math.toRadians(f4);
/* 391 */     this.SnoutLeft.rotateAngleX = (float)Math.toRadians(f4);
/* 392 */     this.ScaleTop1.rotateAngleX = (float)Math.toRadians(f4);
/* 393 */     this.ScaleHead.rotateAngleX = (float)Math.toRadians(f4);
/* 394 */     this.ScaleBackHead.rotateAngleX = (float)Math.toRadians(f4);
/* 395 */     this.HornRightBottom.rotateAngleX = (float)Math.toRadians(f4) - 0.785F;
/* 396 */     this.HornRightTop.rotateAngleX = (float)Math.toRadians(f4) - 0.785F;
/* 397 */     this.HornLeftBottom.rotateAngleX = (float)Math.toRadians(f4) - 0.785F;
/* 398 */     this.HornLeftTop.rotateAngleX = (float)Math.toRadians(f4) - 0.785F;
/*     */     
/* 400 */     this.RightFrontPaw.render(f5);
/* 401 */     this.WingLeft.render(f5);
/* 402 */     this.LegRightFrontTop.render(f5);
/* 403 */     this.LegRightFrontBottom.render(f5);
/* 404 */     this.LegRightBackTop.render(f5);
/* 405 */     this.LegRightBackBottom.render(f5);
/* 406 */     this.RightBackPaw.render(f5);
/* 407 */     this.LegLeftFrontTop.render(f5);
/* 408 */     this.SnoutRight.render(f5);
/* 409 */     this.LeftFrontPaw.render(f5);
/* 410 */     this.LegLeftBackTop.render(f5);
/* 411 */     this.LegLeftBackBottom.render(f5);
/* 412 */     this.LeftBackPaw.render(f5);
/* 413 */     this.LegLeftFrontBottom.render(f5);
/* 414 */     this.TailPieceSmall.render(f5);
/* 415 */     this.JawPiece.render(f5);
/* 416 */     this.HeadPieceBottom.render(f5);
/* 417 */     this.HeadPieceTop.render(f5);
/* 418 */     this.HornRightBottom.render(f5);
/* 419 */     this.HornLeftBottom.render(f5);
/* 420 */     this.HornRightTop.render(f5);
/* 421 */     this.HornLeftTop.render(f5);
/* 422 */     this.Torso.render(f5);
/* 423 */     this.SnoutLeft.render(f5);
/* 424 */     this.WingPieceLeft.render(f5);
/* 425 */     this.WingRight.render(f5);
/* 426 */     this.WingPieceRight.render(f5);
/* 427 */     this.Neck.render(f5);
/* 428 */     this.TailBack.render(f5);
/* 429 */     this.TailFront.render(f5);
/* 430 */     this.ScaleBackHead.render(f5);
/* 431 */     this.TailPieceLarge.render(f5);
/* 432 */     this.ScaleTailPiece.render(f5);
/* 433 */     this.ScaleHead.render(f5);
/* 434 */     this.ScaleTop1.render(f5);
/* 435 */     this.ScaleBackPiece1.render(f5);
/* 436 */     this.ScaleBackPiece2.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 441 */     model.rotateAngleX = x;
/* 442 */     model.rotateAngleY = y;
/* 443 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 448 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelSpyro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */