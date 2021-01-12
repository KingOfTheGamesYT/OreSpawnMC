/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelSpyro
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer RightFrontPaw;
/*     */   
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
/*  53 */     this.wingspeed = f1;
/*     */     
/*  55 */     this.textureWidth = 64;
/*  56 */     this.textureHeight = 64;
/*     */     
/*  58 */     this.RightFrontPaw = new ModelRenderer(this, 12, 31);
/*  59 */     this.RightFrontPaw.addBox(0.0F, 5.0F, -4.0F, 2, 1, 4);
/*  60 */     this.RightFrontPaw.setRotationPoint(3.0F, 18.0F, -2.0F);
/*  61 */     this.RightFrontPaw.setTextureSize(64, 64);
/*  62 */     this.RightFrontPaw.mirror = true;
/*  63 */     setRotation(this.RightFrontPaw, 0.0F, 0.0F, 0.0F);
/*  64 */     this.WingLeft = new ModelRenderer(this, 2, 51);
/*  65 */     this.WingLeft.addBox(-10.0F, -1.0F, -2.0F, 10, 0, 4);
/*  66 */     this.WingLeft.setRotationPoint(-1.0F, 16.0F, 0.0F);
/*  67 */     this.WingLeft.setTextureSize(64, 64);
/*  68 */     this.WingLeft.mirror = true;
/*  69 */     setRotation(this.WingLeft, 0.1745329F, 0.0F, -0.1745329F);
/*  70 */     this.LegRightFrontTop = new ModelRenderer(this, 20, 19);
/*  71 */     this.LegRightFrontTop.addBox(0.0F, 0.0F, -2.0F, 2, 3, 3);
/*  72 */     this.LegRightFrontTop.setRotationPoint(3.0F, 18.0F, -2.0F);
/*  73 */     this.LegRightFrontTop.setTextureSize(64, 64);
/*  74 */     this.LegRightFrontTop.mirror = true;
/*  75 */     setRotation(this.LegRightFrontTop, -0.0872665F, 0.0F, 0.0F);
/*  76 */     this.LegRightFrontBottom = new ModelRenderer(this, 0, 25);
/*  77 */     this.LegRightFrontBottom.addBox(0.0F, 2.0F, -1.5F, 2, 4, 2);
/*  78 */     this.LegRightFrontBottom.setRotationPoint(3.0F, 18.0F, -2.0F);
/*  79 */     this.LegRightFrontBottom.setTextureSize(64, 64);
/*  80 */     this.LegRightFrontBottom.mirror = true;
/*  81 */     setRotation(this.LegRightFrontBottom, -0.1745329F, 0.0F, 0.0F);
/*  82 */     this.LegRightBackTop = new ModelRenderer(this, 30, 19);
/*  83 */     this.LegRightBackTop.addBox(0.0F, 0.0F, -2.0F, 2, 3, 3);
/*  84 */     this.LegRightBackTop.setRotationPoint(3.0F, 18.0F, 3.0F);
/*  85 */     this.LegRightBackTop.setTextureSize(64, 64);
/*  86 */     this.LegRightBackTop.mirror = true;
/*  87 */     setRotation(this.LegRightBackTop, 0.1396263F, 0.0F, 0.0F);
/*  88 */     this.LegRightBackBottom = new ModelRenderer(this, 16, 25);
/*  89 */     this.LegRightBackBottom.addBox(0.0F, 2.0F, -1.0F, 2, 4, 2);
/*  90 */     this.LegRightBackBottom.setRotationPoint(3.0F, 18.0F, 3.0F);
/*  91 */     this.LegRightBackBottom.setTextureSize(64, 64);
/*  92 */     this.LegRightBackBottom.mirror = true;
/*  93 */     setRotation(this.LegRightBackBottom, -0.1745329F, 0.0F, 0.0F);
/*  94 */     this.RightBackPaw = new ModelRenderer(this, 36, 31);
/*  95 */     this.RightBackPaw.addBox(0.0F, 5.0F, -3.0F, 2, 1, 4);
/*  96 */     this.RightBackPaw.setRotationPoint(3.0F, 18.0F, 3.0F);
/*  97 */     this.RightBackPaw.setTextureSize(64, 64);
/*  98 */     this.RightBackPaw.mirror = true;
/*  99 */     setRotation(this.RightBackPaw, 0.0F, 0.0F, 0.0F);
/* 100 */     this.LegLeftFrontTop = new ModelRenderer(this, 0, 19);
/* 101 */     this.LegLeftFrontTop.addBox(-2.0F, 0.0F, -1.0F, 2, 3, 3);
/* 102 */     this.LegLeftFrontTop.setRotationPoint(-2.0F, 18.0F, -3.0F);
/* 103 */     this.LegLeftFrontTop.setTextureSize(64, 64);
/* 104 */     this.LegLeftFrontTop.mirror = true;
/* 105 */     setRotation(this.LegLeftFrontTop, -0.0872665F, 0.0F, 0.0F);
/* 106 */     this.SnoutRight = new ModelRenderer(this, 48, 2);
/* 107 */     this.SnoutRight.addBox(1.0F, -3.0F, -5.0F, 1, 1, 1);
/* 108 */     this.SnoutRight.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 109 */     this.SnoutRight.setTextureSize(64, 64);
/* 110 */     this.SnoutRight.mirror = true;
/* 111 */     setRotation(this.SnoutRight, 0.0F, 0.0F, 0.0F);
/* 112 */     this.LeftFrontPaw = new ModelRenderer(this, 0, 31);
/* 113 */     this.LeftFrontPaw.addBox(-2.0F, 5.0F, -3.0F, 2, 1, 4);
/* 114 */     this.LeftFrontPaw.setRotationPoint(-2.0F, 18.0F, -3.0F);
/* 115 */     this.LeftFrontPaw.setTextureSize(64, 64);
/* 116 */     this.LeftFrontPaw.mirror = true;
/* 117 */     setRotation(this.LeftFrontPaw, 0.0F, 0.0F, 0.0F);
/* 118 */     this.LegLeftBackTop = new ModelRenderer(this, 10, 19);
/* 119 */     this.LegLeftBackTop.addBox(-2.0F, 0.0F, -2.0F, 2, 3, 3);
/* 120 */     this.LegLeftBackTop.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 121 */     this.LegLeftBackTop.setTextureSize(64, 64);
/* 122 */     this.LegLeftBackTop.mirror = true;
/* 123 */     setRotation(this.LegLeftBackTop, 0.1396263F, 0.0F, 0.0F);
/* 124 */     this.LegLeftBackBottom = new ModelRenderer(this, 24, 25);
/* 125 */     this.LegLeftBackBottom.addBox(-2.0F, 2.0F, -1.0F, 2, 4, 2);
/* 126 */     this.LegLeftBackBottom.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 127 */     this.LegLeftBackBottom.setTextureSize(64, 64);
/* 128 */     this.LegLeftBackBottom.mirror = true;
/* 129 */     setRotation(this.LegLeftBackBottom, -0.1745329F, 0.0F, 0.0F);
/* 130 */     this.LeftBackPaw = new ModelRenderer(this, 24, 31);
/* 131 */     this.LeftBackPaw.addBox(-2.0F, 5.0F, -3.0F, 2, 1, 4);
/* 132 */     this.LeftBackPaw.setRotationPoint(-2.0F, 18.0F, 3.0F);
/* 133 */     this.LeftBackPaw.setTextureSize(64, 64);
/* 134 */     this.LeftBackPaw.mirror = true;
/* 135 */     setRotation(this.LeftBackPaw, 0.0F, 0.0F, 0.0F);
/* 136 */     this.LegLeftFrontBottom = new ModelRenderer(this, 8, 25);
/* 137 */     this.LegLeftFrontBottom.addBox(-2.0F, 2.0F, -0.5F, 2, 4, 2);
/* 138 */     this.LegLeftFrontBottom.setRotationPoint(-2.0F, 18.0F, -3.0F);
/* 139 */     this.LegLeftFrontBottom.setTextureSize(64, 64);
/* 140 */     this.LegLeftFrontBottom.mirror = true;
/* 141 */     setRotation(this.LegLeftFrontBottom, -0.1745329F, 0.0F, 0.0F);
/* 142 */     this.TailPieceSmall = new ModelRenderer(this, 28, 36);
/* 143 */     this.TailPieceSmall.addBox(0.0F, -0.5F, 4.0F, 1, 1, 1);
/* 144 */     this.TailPieceSmall.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 145 */     this.TailPieceSmall.setTextureSize(64, 64);
/* 146 */     this.TailPieceSmall.mirror = true;
/* 147 */     setRotation(this.TailPieceSmall, 0.1745329F, 0.0F, 0.0F);
/* 148 */     this.JawPiece = new ModelRenderer(this, 52, 0);
/* 149 */     this.JawPiece.addBox(-2.0F, -1.0F, -4.0F, 3, 1, 3);
/* 150 */     this.JawPiece.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 151 */     this.JawPiece.setTextureSize(64, 64);
/* 152 */     this.JawPiece.mirror = true;
/* 153 */     setRotation(this.JawPiece, 0.1745329F, 0.0F, 0.0F);
/* 154 */     this.HeadPieceBottom = new ModelRenderer(this, 30, 7);
/* 155 */     this.HeadPieceBottom.addBox(-3.0F, -2.0F, -5.0F, 5, 2, 6);
/* 156 */     this.HeadPieceBottom.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 157 */     this.HeadPieceBottom.setTextureSize(64, 64);
/* 158 */     this.HeadPieceBottom.mirror = true;
/* 159 */     setRotation(this.HeadPieceBottom, 0.0F, 0.0F, 0.0F);
/* 160 */     this.HeadPieceTop = new ModelRenderer(this, 30, 0);
/* 161 */     this.HeadPieceTop.addBox(-3.0F, -5.0F, -3.0F, 5, 3, 4);
/* 162 */     this.HeadPieceTop.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 163 */     this.HeadPieceTop.setTextureSize(64, 64);
/* 164 */     this.HeadPieceTop.mirror = true;
/* 165 */     setRotation(this.HeadPieceTop, 0.0F, 0.0F, 0.0F);
/* 166 */     this.HornRightBottom = new ModelRenderer(this, 8, 14);
/* 167 */     this.HornRightBottom.addBox(0.0F, -6.0F, -3.5F, 2, 3, 2);
/* 168 */     this.HornRightBottom.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 169 */     this.HornRightBottom.setTextureSize(64, 64);
/* 170 */     this.HornRightBottom.mirror = true;
/* 171 */     setRotation(this.HornRightBottom, -0.7853982F, 0.7853982F, 0.0F);
/* 172 */     this.HornLeftBottom = new ModelRenderer(this, 0, 14);
/* 173 */     this.HornLeftBottom.addBox(-2.75F, -6.5F, -3.0F, 2, 3, 2);
/* 174 */     this.HornLeftBottom.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 175 */     this.HornLeftBottom.setTextureSize(64, 64);
/* 176 */     this.HornLeftBottom.mirror = true;
/* 177 */     setRotation(this.HornLeftBottom, -0.7853982F, -0.7853982F, 0.0F);
/* 178 */     this.HornRightTop = new ModelRenderer(this, 20, 14);
/* 179 */     this.HornRightTop.addBox(0.5F, -9.0F, -3.0F, 1, 3, 1);
/* 180 */     this.HornRightTop.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 181 */     this.HornRightTop.setTextureSize(64, 64);
/* 182 */     this.HornRightTop.mirror = true;
/* 183 */     setRotation(this.HornRightTop, -0.7853982F, 0.7853982F, 0.0F);
/* 184 */     this.HornLeftTop = new ModelRenderer(this, 16, 14);
/* 185 */     this.HornLeftTop.addBox(-2.2F, -9.5F, -2.5F, 1, 3, 1);
/* 186 */     this.HornLeftTop.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 187 */     this.HornLeftTop.setTextureSize(64, 64);
/* 188 */     this.HornLeftTop.mirror = true;
/* 189 */     setRotation(this.HornLeftTop, -0.7853982F, -0.7853982F, 0.0F);
/* 190 */     this.Torso = new ModelRenderer(this, 0, 0);
/* 191 */     this.Torso.addBox(-2.0F, -2.0F, -5.0F, 5, 4, 10);
/* 192 */     this.Torso.setRotationPoint(0.0F, 19.0F, 0.0F);
/* 193 */     this.Torso.setTextureSize(64, 64);
/* 194 */     this.Torso.mirror = true;
/* 195 */     setRotation(this.Torso, 0.0F, 0.0F, 0.0F);
/* 196 */     this.SnoutLeft = new ModelRenderer(this, 48, 0);
/* 197 */     this.SnoutLeft.addBox(-3.0F, -3.0F, -5.0F, 1, 1, 1);
/* 198 */     this.SnoutLeft.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 199 */     this.SnoutLeft.setTextureSize(64, 64);
/* 200 */     this.SnoutLeft.mirror = true;
/* 201 */     setRotation(this.SnoutLeft, 0.0F, 0.0F, 0.0F);
/* 202 */     this.WingPieceLeft = new ModelRenderer(this, 4, 42);
/* 203 */     this.WingPieceLeft.addBox(-1.0F, -2.0F, -1.0F, 1, 2, 1);
/* 204 */     this.WingPieceLeft.setRotationPoint(0.0F, 17.2F, 0.0F);
/* 205 */     this.WingPieceLeft.setTextureSize(64, 64);
/* 206 */     this.WingPieceLeft.mirror = true;
/* 207 */     setRotation(this.WingPieceLeft, 0.1745329F, 0.0F, -0.1745329F);
/* 208 */     this.WingRight = new ModelRenderer(this, 2, 45);
/* 209 */     this.WingRight.addBox(0.0F, -1.0F, -2.0F, 10, 0, 4);
/* 210 */     this.WingRight.setRotationPoint(2.0F, 16.0F, 0.0F);
/* 211 */     this.WingRight.setTextureSize(64, 64);
/* 212 */     this.WingRight.mirror = true;
/* 213 */     setRotation(this.WingRight, 0.1745329F, 0.0F, 0.1745329F);
/* 214 */     this.WingPieceRight = new ModelRenderer(this, 0, 42);
/* 215 */     this.WingPieceRight.addBox(-1.0F, -2.0F, 0.0F, 1, 2, 1);
/* 216 */     this.WingPieceRight.setRotationPoint(2.0F, 17.5F, -1.0F);
/* 217 */     this.WingPieceRight.setTextureSize(64, 64);
/* 218 */     this.WingPieceRight.mirror = true;
/* 219 */     setRotation(this.WingPieceRight, 0.1745329F, 0.0F, 0.1745329F);
/* 220 */     this.Neck = new ModelRenderer(this, 52, 7);
/* 221 */     this.Neck.addBox(-1.0F, -2.0F, -1.0F, 3, 3, 3);
/* 222 */     this.Neck.setRotationPoint(0.0F, 17.0F, -4.0F);
/* 223 */     this.Neck.setTextureSize(64, 64);
/* 224 */     this.Neck.mirror = true;
/* 225 */     setRotation(this.Neck, 0.4537856F, 0.0F, 0.0F);
/* 226 */     this.TailBack = new ModelRenderer(this, 0, 36);
/* 227 */     this.TailBack.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4);
/* 228 */     this.TailBack.setRotationPoint(0.5F, 17.5F, 5.0F);
/* 229 */     this.TailBack.setTextureSize(64, 64);
/* 230 */     this.TailBack.mirror = true;
/* 231 */     setRotation(this.TailBack, 0.4537856F, 0.0F, 0.0F);
/* 232 */     this.TailFront = new ModelRenderer(this, 12, 36);
/* 233 */     this.TailFront.addBox(0.0F, 0.0F, -1.0F, 1, 1, 4);
/* 234 */     this.TailFront.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 235 */     this.TailFront.setTextureSize(64, 64);
/* 236 */     this.TailFront.mirror = true;
/* 237 */     setRotation(this.TailFront, 0.2617994F, 0.0F, 0.0F);
/* 238 */     this.ScaleBackHead = new ModelRenderer(this, 38, 36);
/* 239 */     this.ScaleBackHead.addBox(-1.0F, -3.0F, 2.0F, 1, 2, 1);
/* 240 */     this.ScaleBackHead.setRotationPoint(1.0F, 16.0F, -4.0F);
/* 241 */     this.ScaleBackHead.setTextureSize(64, 64);
/* 242 */     this.ScaleBackHead.mirror = true;
/* 243 */     setRotation(this.ScaleBackHead, 0.0F, 0.0F, 0.0F);
/* 244 */     this.TailPieceLarge = new ModelRenderer(this, 22, 36);
/* 245 */     this.TailPieceLarge.addBox(0.0F, -1.0F, 2.0F, 1, 2, 2);
/* 246 */     this.TailPieceLarge.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 247 */     this.TailPieceLarge.setTextureSize(64, 64);
/* 248 */     this.TailPieceLarge.mirror = true;
/* 249 */     setRotation(this.TailPieceLarge, 0.1745329F, 0.0F, 0.0F);
/* 250 */     this.ScaleTailPiece = new ModelRenderer(this, 48, 36);
/* 251 */     this.ScaleTailPiece.addBox(-0.5F, -2.0F, 0.2F, 1, 1, 2);
/* 252 */     this.ScaleTailPiece.setRotationPoint(0.5F, 17.5F, 5.0F);
/* 253 */     this.ScaleTailPiece.setTextureSize(64, 64);
/* 254 */     this.ScaleTailPiece.mirror = true;
/* 255 */     setRotation(this.ScaleTailPiece, 0.4537856F, 0.0F, 0.0F);
/* 256 */     this.ScaleHead = new ModelRenderer(this, 42, 36);
/* 257 */     this.ScaleHead.addBox(-1.0F, -6.0F, 0.0F, 1, 2, 2);
/* 258 */     this.ScaleHead.setRotationPoint(1.0F, 16.0F, -3.0F);
/* 259 */     this.ScaleHead.setTextureSize(64, 64);
/* 260 */     this.ScaleHead.mirror = true;
/* 261 */     setRotation(this.ScaleHead, 0.0F, 0.0F, 0.0F);
/* 262 */     this.ScaleTop1 = new ModelRenderer(this, 48, 36);
/* 263 */     this.ScaleTop1.addBox(-1.0F, -6.0F, -4.0F, 1, 1, 2);
/* 264 */     this.ScaleTop1.setRotationPoint(1.0F, 16.0F, -2.0F);
/* 265 */     this.ScaleTop1.setTextureSize(64, 64);
/* 266 */     this.ScaleTop1.mirror = true;
/* 267 */     setRotation(this.ScaleTop1, 0.0F, 0.0F, 0.0F);
/* 268 */     this.ScaleBackPiece1 = new ModelRenderer(this, 48, 36);
/* 269 */     this.ScaleBackPiece1.addBox(0.0F, -1.0F, -1.0F, 1, 1, 2);
/* 270 */     this.ScaleBackPiece1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 271 */     this.ScaleBackPiece1.setTextureSize(64, 64);
/* 272 */     this.ScaleBackPiece1.mirror = true;
/* 273 */     setRotation(this.ScaleBackPiece1, 0.0F, 0.0F, 0.0F);
/* 274 */     this.ScaleBackPiece2 = new ModelRenderer(this, 48, 36);
/* 275 */     this.ScaleBackPiece2.addBox(0.0F, -1.0F, -1.0F, 1, 1, 2);
/* 276 */     this.ScaleBackPiece2.setRotationPoint(0.0F, 17.0F, 3.0F);
/* 277 */     this.ScaleBackPiece2.setTextureSize(64, 64);
/* 278 */     this.ScaleBackPiece2.mirror = true;
/* 279 */     setRotation(this.ScaleBackPiece2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 287 */     Spyro c = (Spyro)entity;
/* 288 */     float hf = 0.0F;
/* 289 */     float newangle = 0.0F;
/* 290 */     int current_activity = c.getActivity();
/*     */     
/* 292 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 293 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     if (f1 > 0.1D) {
/* 299 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/*     */     } else {
/* 301 */       newangle = 0.0F;
/*     */     } 
/* 303 */     if (current_activity == 3) newangle *= 0.5F;
/*     */     
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
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 442 */     model.rotateAngleX = x;
/* 443 */     model.rotateAngleY = y;
/* 444 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 449 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSpyro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */