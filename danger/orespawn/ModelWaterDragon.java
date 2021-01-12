/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelWaterDragon
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Head;
/*     */   
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer body1;
/*     */   ModelRenderer Leg8;
/*     */   ModelRenderer Leg2;
/*     */   ModelRenderer Leg7;
/*     */   ModelRenderer Leg1;
/*     */   ModelRenderer neck2;
/*     */   ModelRenderer neck3;
/*     */   ModelRenderer neck4;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer body3;
/*     */   ModelRenderer body4;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tailmiddle;
/*     */   ModelRenderer tailtop;
/*     */   ModelRenderer tailbottom;
/*     */   ModelRenderer nose;
/*     */   ModelRenderer headfin;
/*     */   ModelRenderer rightear;
/*     */   ModelRenderer leftear;
/*     */   ModelRenderer neackfin;
/*     */   ModelRenderer Bodyfin;
/*     */   ModelRenderer jaw;
/*     */   
/*     */   public ModelWaterDragon(float f1) {
/*  41 */     this.wingspeed = f1;
/*     */     
/*  43 */     this.textureWidth = 128;
/*  44 */     this.textureHeight = 128;
/*     */     
/*  46 */     this.Head = new ModelRenderer(this, 79, 64);
/*  47 */     this.Head.addBox(-4.0F, -4.0F, -8.0F, 7, 8, 8);
/*  48 */     this.Head.setRotationPoint(0.0F, 0.0F, -3.0F);
/*  49 */     this.Head.setTextureSize(128, 128);
/*  50 */     this.Head.mirror = true;
/*  51 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*  52 */     this.neck1 = new ModelRenderer(this, 29, 70);
/*  53 */     this.neck1.addBox(-2.0F, 0.0F, -3.0F, 5, 5, 5);
/*  54 */     this.neck1.setRotationPoint(-1.0F, 4.0F, -5.0F);
/*  55 */     this.neck1.setTextureSize(128, 128);
/*  56 */     this.neck1.mirror = true;
/*  57 */     setRotation(this.neck1, -0.1858931F, 0.0F, 0.0F);
/*  58 */     this.body1 = new ModelRenderer(this, 0, 33);
/*  59 */     this.body1.addBox(-5.0F, -4.0F, -6.0F, 9, 9, 9);
/*  60 */     this.body1.setRotationPoint(0.0F, 19.0F, 2.0F);
/*  61 */     this.body1.setTextureSize(128, 128);
/*  62 */     this.body1.mirror = true;
/*  63 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/*  64 */     this.Leg8 = new ModelRenderer(this, 23, 25);
/*  65 */     this.Leg8.addBox(0.0F, -1.0F, -1.0F, 9, 2, 3);
/*  66 */     this.Leg8.setRotationPoint(3.0F, 22.0F, -2.0F);
/*  67 */     this.Leg8.setTextureSize(128, 128);
/*  68 */     this.Leg8.mirror = true;
/*  69 */     setRotation(this.Leg8, 0.0F, 0.5759587F, 0.1919862F);
/*  70 */     this.Leg2 = new ModelRenderer(this, 80, 18);
/*  71 */     this.Leg2.addBox(0.0F, -1.0F, -1.0F, 9, 2, 3);
/*  72 */     this.Leg2.setRotationPoint(2.0F, 22.0F, 13.0F);
/*  73 */     this.Leg2.setTextureSize(128, 128);
/*  74 */     this.Leg2.mirror = true;
/*  75 */     setRotation(this.Leg2, 0.0F, -0.5759587F, 0.1919862F);
/*  76 */     this.Leg7 = new ModelRenderer(this, 23, 18);
/*  77 */     this.Leg7.addBox(-9.0F, -1.0F, -1.0F, 9, 2, 3);
/*  78 */     this.Leg7.setRotationPoint(-4.0F, 22.0F, -1.0F);
/*  79 */     this.Leg7.setTextureSize(128, 128);
/*  80 */     this.Leg7.mirror = true;
/*  81 */     setRotation(this.Leg7, 0.0F, -0.5759587F, -0.1919862F);
/*  82 */     this.Leg1 = new ModelRenderer(this, 80, 25);
/*  83 */     this.Leg1.addBox(-9.0F, -1.0F, -2.0F, 9, 2, 3);
/*  84 */     this.Leg1.setRotationPoint(-3.0F, 22.0F, 14.0F);
/*  85 */     this.Leg1.setTextureSize(128, 128);
/*  86 */     this.Leg1.mirror = true;
/*  87 */     setRotation(this.Leg1, 0.0F, 0.5759587F, -0.1919862F);
/*  88 */     this.neck2 = new ModelRenderer(this, 0, 11);
/*  89 */     this.neck2.addBox(-2.0F, 0.0F, -2.0F, 5, 5, 5);
/*  90 */     this.neck2.setRotationPoint(-1.0F, 9.0F, -7.0F);
/*  91 */     this.neck2.setTextureSize(128, 128);
/*  92 */     this.neck2.mirror = true;
/*  93 */     setRotation(this.neck2, 0.1115358F, 0.0F, 0.0F);
/*  94 */     this.neck3 = new ModelRenderer(this, 0, 22);
/*  95 */     this.neck3.addBox(-2.0F, 0.0F, -2.0F, 5, 5, 5);
/*  96 */     this.neck3.setRotationPoint(-1.0F, 14.0F, -6.0F);
/*  97 */     this.neck3.setTextureSize(128, 128);
/*  98 */     this.neck3.mirror = true;
/*  99 */     setRotation(this.neck3, 0.4461433F, 0.0F, 0.0F);
/* 100 */     this.neck4 = new ModelRenderer(this, 26, 12);
/* 101 */     this.neck4.addBox(-3.0F, 0.0F, -2.0F, 5, 3, 3);
/* 102 */     this.neck4.setRotationPoint(0.0F, 18.0F, -4.0F);
/* 103 */     this.neck4.setTextureSize(128, 128);
/* 104 */     this.neck4.mirror = true;
/* 105 */     setRotation(this.neck4, 1.226894F, 0.0F, 0.0F);
/* 106 */     this.body2 = new ModelRenderer(this, 0, 52);
/* 107 */     this.body2.addBox(-5.0F, -5.0F, 0.0F, 7, 7, 9);
/* 108 */     this.body2.setRotationPoint(1.0F, 21.0F, 5.0F);
/* 109 */     this.body2.setTextureSize(128, 128);
/* 110 */     this.body2.mirror = true;
/* 111 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/* 112 */     this.body3 = new ModelRenderer(this, 0, 69);
/* 113 */     this.body3.addBox(-3.0F, -3.0F, 0.0F, 5, 5, 7);
/* 114 */     this.body3.setRotationPoint(0.0F, 20.0F, 14.0F);
/* 115 */     this.body3.setTextureSize(128, 128);
/* 116 */     this.body3.mirror = true;
/* 117 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/* 118 */     this.body4 = new ModelRenderer(this, 0, 89);
/* 119 */     this.body4.addBox(-1.0F, -1.0F, 0.0F, 3, 3, 5);
/* 120 */     this.body4.setRotationPoint(-1.0F, 19.0F, 21.0F);
/* 121 */     this.body4.setTextureSize(128, 128);
/* 122 */     this.body4.mirror = true;
/* 123 */     setRotation(this.body4, 0.0F, 0.0F, 0.0F);
/* 124 */     this.tail1 = new ModelRenderer(this, 0, 82);
/* 125 */     this.tail1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
/* 126 */     this.tail1.setRotationPoint(-1.0F, 19.0F, 25.0F);
/* 127 */     this.tail1.setTextureSize(128, 128);
/* 128 */     this.tail1.mirror = true;
/* 129 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/* 130 */     this.tailmiddle = new ModelRenderer(this, 55, 37);
/* 131 */     this.tailmiddle.addBox(-1.0F, -6.0F, 0.0F, 2, 11, 9);
/* 132 */     this.tailmiddle.setRotationPoint(0.0F, 19.0F, 28.0F);
/* 133 */     this.tailmiddle.setTextureSize(128, 128);
/* 134 */     this.tailmiddle.mirror = true;
/* 135 */     setRotation(this.tailmiddle, 0.0F, 0.0F, 0.0F);
/* 136 */     this.tailtop = new ModelRenderer(this, 82, 36);
/* 137 */     this.tailtop.addBox(-1.0F, -11.0F, 0.0F, 2, 11, 9);
/* 138 */     this.tailtop.setRotationPoint(0.0F, 14.0F, 28.0F);
/* 139 */     this.tailtop.setTextureSize(128, 128);
/* 140 */     this.tailtop.mirror = true;
/* 141 */     setRotation(this.tailtop, -0.6320364F, 0.0F, 0.0F);
/* 142 */     this.tailbottom = new ModelRenderer(this, 56, 60);
/* 143 */     this.tailbottom.addBox(0.0F, 0.0F, 0.0F, 2, 11, 9);
/* 144 */     this.tailbottom.setRotationPoint(-1.0F, 23.0F, 28.0F);
/* 145 */     this.tailbottom.setTextureSize(128, 128);
/* 146 */     this.tailbottom.mirror = true;
/* 147 */     setRotation(this.tailbottom, 0.6320361F, 0.0F, -0.0174533F);
/* 148 */     this.nose = new ModelRenderer(this, 54, 19);
/* 149 */     this.nose.addBox(-3.0F, -2.0F, -5.0F, 5, 5, 5);
/* 150 */     this.nose.setRotationPoint(0.0F, -2.0F, -11.0F);
/* 151 */     this.nose.setTextureSize(128, 128);
/* 152 */     this.nose.mirror = true;
/* 153 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/* 154 */     this.headfin = new ModelRenderer(this, 0, 99);
/* 155 */     this.headfin.addBox(0.0F, -5.0F, 0.0F, 0, 10, 9);
/* 156 */     this.headfin.setRotationPoint(0.0F, -4.0F, -6.0F);
/* 157 */     this.headfin.setTextureSize(128, 128);
/* 158 */     this.headfin.mirror = true;
/* 159 */     setRotation(this.headfin, 0.1396263F, 0.0F, 0.0F);
/* 160 */     this.rightear = new ModelRenderer(this, 38, 32);
/* 161 */     this.rightear.addBox(0.0F, 0.0F, 0.0F, 0, 5, 5);
/* 162 */     this.rightear.setRotationPoint(-4.0F, -2.0F, -5.0F);
/* 163 */     this.rightear.setTextureSize(128, 128);
/* 164 */     this.rightear.mirror = true;
/* 165 */     setRotation(this.rightear, 0.0698132F, -0.418879F, 0.0F);
/* 166 */     this.leftear = new ModelRenderer(this, 38, 32);
/* 167 */     this.leftear.addBox(0.0F, 0.0F, 0.0F, 0, 5, 5);
/* 168 */     this.leftear.setRotationPoint(3.0F, -2.0F, -5.0F);
/* 169 */     this.leftear.setTextureSize(128, 128);
/* 170 */     this.leftear.mirror = true;
/* 171 */     setRotation(this.leftear, 0.0698132F, 0.418879F, 0.0F);
/* 172 */     this.neackfin = new ModelRenderer(this, 42, 47);
/* 173 */     this.neackfin.addBox(0.0F, -1.0F, 0.0F, 0, 5, 5);
/* 174 */     this.neackfin.setRotationPoint(0.0F, 3.0F, -3.0F);
/* 175 */     this.neackfin.setTextureSize(128, 128);
/* 176 */     this.neackfin.mirror = true;
/* 177 */     setRotation(this.neackfin, -0.185895F, 0.0F, 0.0F);
/* 178 */     this.Bodyfin = new ModelRenderer(this, 21, 91);
/* 179 */     this.Bodyfin.addBox(0.0F, -6.0F, -3.0F, 0, 10, 9);
/* 180 */     this.Bodyfin.setRotationPoint(0.0F, 15.0F, 2.0F);
/* 181 */     this.Bodyfin.setTextureSize(128, 128);
/* 182 */     this.Bodyfin.mirror = true;
/* 183 */     setRotation(this.Bodyfin, -0.0698132F, 0.0F, 0.0F);
/* 184 */     this.jaw = new ModelRenderer(this, 76, 8);
/* 185 */     this.jaw.addBox(-2.0F, 0.0F, -5.0F, 5, 1, 5);
/* 186 */     this.jaw.setRotationPoint(-1.0F, 3.0F, -10.0F);
/* 187 */     this.jaw.setTextureSize(128, 128);
/* 188 */     this.jaw.mirror = true;
/* 189 */     setRotation(this.jaw, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 195 */     WaterDragon e = (WaterDragon)entity;
/* 196 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 197 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 198 */     float newangle = 0.0F;
/* 199 */     float pi4 = 0.7853982F;
/* 200 */     float root13 = (float)Math.sqrt(13.0D);
/* 201 */     float root20 = (float)Math.sqrt(20.0D);
/*     */ 
/*     */     
/* 204 */     if (f1 > 0.1D) {
/* 205 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.2F * f1;
/*     */     } else {
/* 207 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     this.body3.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 214 */     this.body3.rotationPointZ += (float)Math.cos(this.body3.rotateAngleY) * 7.0F;
/* 215 */     this.body4.rotationPointX = this.body3.rotationPointX - 1.0F + (float)Math.sin(this.body3.rotateAngleY) * 7.0F;
/* 216 */     this.body4.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - pi4) * 3.1415927F * 0.4F * f1;
/* 217 */     this.body4.rotationPointZ += (float)Math.cos(this.body4.rotateAngleY) * 5.0F;
/* 218 */     this.body4.rotationPointX += (float)Math.sin(this.body4.rotateAngleY) * 5.0F;
/* 219 */     this.tail1.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.4F * f1;
/* 220 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 3.0F;
/* 221 */     this.tail1.rotationPointX += (float)Math.sin(this.tail1.rotateAngleY) * 3.0F;
/* 222 */     this.tailmiddle.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.4F * f1;
/* 223 */     this.tailtop.rotateAngleY = this.tailmiddle.rotateAngleY;
/* 224 */     this.tailtop.rotationPointZ = this.tailmiddle.rotationPointZ;
/* 225 */     this.tailtop.rotationPointX = this.tailmiddle.rotationPointX;
/* 226 */     this.tailbottom.rotateAngleY = this.tailmiddle.rotateAngleY;
/* 227 */     this.tailbottom.rotationPointZ = this.tailmiddle.rotationPointZ;
/* 228 */     this.tailbottom.rotationPointX = this.tailmiddle.rotationPointX;
/*     */ 
/*     */     
/* 231 */     this.Leg8.rotateAngleY = 0.58F + newangle;
/* 232 */     this.Leg2.rotateAngleY = -0.58F + newangle;
/* 233 */     this.Leg7.rotateAngleY = -0.58F - newangle;
/* 234 */     this.Leg1.rotateAngleY = 0.58F - newangle;
/*     */ 
/*     */     
/* 237 */     newangle = MathHelper.cos(f2 * 0.8F * this.wingspeed) * 3.1415927F * 0.1F;
/* 238 */     this.leftear.rotateAngleY = 0.62F + newangle;
/* 239 */     this.rightear.rotateAngleY = -0.62F - newangle;
/*     */ 
/*     */     
/* 242 */     newangle = MathHelper.cos(f2 * 0.7F * this.wingspeed) * 3.1415927F * 0.02F;
/* 243 */     if (e.isSitting()) newangle = 0.0F; 
/* 244 */     this.Bodyfin.rotateAngleZ = newangle;
/* 245 */     newangle = MathHelper.cos(f2 * 0.6F * this.wingspeed) * 3.1415927F * 0.1F;
/* 246 */     if (e.isSitting()) newangle = 0.0F; 
/* 247 */     this.neackfin.rotateAngleY = newangle;
/* 248 */     newangle = MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.05F;
/* 249 */     if (e.isSitting()) newangle = 0.0F; 
/* 250 */     this.headfin.rotateAngleY = newangle;
/*     */ 
/*     */     
/* 253 */     if (e.getAttacking() == 1) {
/*     */       
/* 255 */       newangle = MathHelper.cos(f2 * 1.2F * this.wingspeed) * 3.1415927F * 0.25F;
/* 256 */       this.jaw.rotateAngleX = newangle;
/* 257 */     } else if (e.getAttacking() == 2) {
/*     */       
/* 259 */       this.jaw.rotateAngleX = 0.45F;
/*     */     } else {
/*     */       
/* 262 */       this.jaw.rotateAngleX = -0.25F;
/*     */     } 
/*     */ 
/*     */     
/* 266 */     newangle = (float)Math.toRadians(f3) * 0.75F;
/* 267 */     this.Head.rotateAngleY = newangle;
/* 268 */     this.nose.rotateAngleY = newangle;
/* 269 */     this.Head.rotationPointZ -= (float)Math.cos(this.Head.rotateAngleY) * 8.0F;
/* 270 */     this.Head.rotationPointX -= (float)Math.sin(this.Head.rotateAngleY) * 8.0F;
/* 271 */     this.jaw.rotateAngleY = newangle;
/* 272 */     this.Head.rotationPointZ -= (float)Math.cos(this.Head.rotateAngleY) * 7.0F;
/* 273 */     this.jaw.rotationPointX = this.Head.rotationPointX - (float)Math.sin(this.Head.rotateAngleY) * 7.0F - 1.0F;
/* 274 */     this.headfin.rotateAngleY = newangle;
/* 275 */     this.Head.rotationPointZ -= (float)Math.cos(this.Head.rotateAngleY) * 3.0F;
/* 276 */     this.Head.rotationPointX -= (float)Math.sin(this.Head.rotateAngleY) * 3.0F;
/* 277 */     this.leftear.rotateAngleY += newangle;
/* 278 */     this.Head.rotationPointZ -= (float)Math.cos((this.Head.rotateAngleY - pi4)) * root13;
/* 279 */     this.Head.rotationPointX -= (float)Math.sin((this.Head.rotateAngleY - pi4)) * root13;
/* 280 */     this.rightear.rotateAngleY += newangle;
/* 281 */     this.Head.rotationPointZ -= (float)Math.cos((this.Head.rotateAngleY + pi4)) * root20;
/* 282 */     this.Head.rotationPointX -= (float)Math.sin((this.Head.rotateAngleY + pi4)) * root20;
/*     */ 
/*     */ 
/*     */     
/* 286 */     this.Head.render(f5);
/* 287 */     this.neck1.render(f5);
/* 288 */     this.body1.render(f5);
/* 289 */     this.Leg8.render(f5);
/* 290 */     this.Leg2.render(f5);
/* 291 */     this.Leg7.render(f5);
/* 292 */     this.Leg1.render(f5);
/* 293 */     this.neck2.render(f5);
/* 294 */     this.neck3.render(f5);
/* 295 */     this.neck4.render(f5);
/* 296 */     this.body2.render(f5);
/* 297 */     this.body3.render(f5);
/* 298 */     this.body4.render(f5);
/* 299 */     this.tail1.render(f5);
/* 300 */     this.tailmiddle.render(f5);
/* 301 */     this.tailtop.render(f5);
/* 302 */     this.tailbottom.render(f5);
/* 303 */     this.nose.render(f5);
/* 304 */     this.headfin.render(f5);
/* 305 */     this.rightear.render(f5);
/* 306 */     this.leftear.render(f5);
/* 307 */     this.neackfin.render(f5);
/* 308 */     this.Bodyfin.render(f5);
/* 309 */     this.jaw.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 315 */     model.rotateAngleX = x;
/* 316 */     model.rotateAngleY = y;
/* 317 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 322 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelWaterDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */