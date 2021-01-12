/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPointysaurus
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer lfleg;
/*     */   
/*     */   ModelRenderer rfleg;
/*     */   
/*     */   ModelRenderer lrleg;
/*     */   ModelRenderer rrleg;
/*     */   ModelRenderer body1;
/*     */   ModelRenderer head;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer body3;
/*     */   ModelRenderer guard;
/*     */   ModelRenderer nose;
/*     */   ModelRenderer lhorn;
/*     */   ModelRenderer rhorn;
/*     */   ModelRenderer chorn;
/*     */   ModelRenderer tail;
/*     */   ModelRenderer bump1;
/*     */   ModelRenderer bump2;
/*     */   ModelRenderer bump3;
/*     */   ModelRenderer bump4;
/*     */   ModelRenderer bump5;
/*     */   ModelRenderer bump6;
/*     */   ModelRenderer bump7;
/*     */   ModelRenderer bump8;
/*     */   ModelRenderer bump9;
/*     */   ModelRenderer bump10;
/*     */   ModelRenderer bump11;
/*     */   ModelRenderer bump12;
/*     */   ModelRenderer bump13;
/*     */   ModelRenderer bump14;
/*     */   ModelRenderer bump15;
/*     */   ModelRenderer bump16;
/*     */   
/*     */   public ModelPointysaurus(float f1) {
/*  47 */     this.wingspeed = f1;
/*     */     
/*  49 */     this.textureWidth = 128;
/*  50 */     this.textureHeight = 128;
/*     */     
/*  52 */     this.lfleg = new ModelRenderer(this, 102, 66);
/*  53 */     this.lfleg.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/*  54 */     this.lfleg.setRotationPoint(9.0F, 16.0F, -8.0F);
/*  55 */     this.lfleg.setTextureSize(128, 128);
/*  56 */     this.lfleg.mirror = true;
/*  57 */     setRotation(this.lfleg, 0.0F, 0.0F, 0.0F);
/*  58 */     this.rfleg = new ModelRenderer(this, 102, 66);
/*  59 */     this.rfleg.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/*  60 */     this.rfleg.setRotationPoint(-9.0F, 16.0F, -8.0F);
/*  61 */     this.rfleg.setTextureSize(128, 128);
/*  62 */     this.rfleg.mirror = true;
/*  63 */     setRotation(this.rfleg, 0.0F, 0.0F, 0.0F);
/*  64 */     this.lrleg = new ModelRenderer(this, 0, 0);
/*  65 */     this.lrleg.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
/*  66 */     this.lrleg.setRotationPoint(9.0F, 16.0F, 12.0F);
/*  67 */     this.lrleg.setTextureSize(128, 128);
/*  68 */     this.lrleg.mirror = true;
/*  69 */     setRotation(this.lrleg, 0.0F, 0.0F, 0.0F);
/*  70 */     this.rrleg = new ModelRenderer(this, 0, 0);
/*  71 */     this.rrleg.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
/*  72 */     this.rrleg.setRotationPoint(-9.0F, 16.0F, 12.0F);
/*  73 */     this.rrleg.setTextureSize(128, 128);
/*  74 */     this.rrleg.mirror = true;
/*  75 */     setRotation(this.rrleg, 0.0F, 0.0F, 0.0F);
/*  76 */     this.body1 = new ModelRenderer(this, 0, 87);
/*  77 */     this.body1.addBox(-4.0F, 0.0F, 0.0F, 22, 9, 30);
/*  78 */     this.body1.setRotationPoint(-7.0F, 9.0F, -12.0F);
/*  79 */     this.body1.setTextureSize(128, 128);
/*  80 */     this.body1.mirror = true;
/*  81 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/*  82 */     this.head = new ModelRenderer(this, 70, 0);
/*  83 */     this.head.addBox(-6.0F, -10.0F, -12.0F, 12, 10, 12);
/*  84 */     this.head.setRotationPoint(0.0F, 11.0F, -7.0F);
/*  85 */     this.head.setTextureSize(128, 128);
/*  86 */     this.head.mirror = true;
/*  87 */     setRotation(this.head, -0.1919862F, 0.0F, 0.0F);
/*  88 */     this.body2 = new ModelRenderer(this, 0, 63);
/*  89 */     this.body2.addBox(-9.0F, 0.0F, 0.0F, 18, 7, 15);
/*  90 */     this.body2.setRotationPoint(0.0F, 2.0F, -9.0F);
/*  91 */     this.body2.setTextureSize(128, 128);
/*  92 */     this.body2.mirror = true;
/*  93 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  94 */     this.body3 = new ModelRenderer(this, 0, 44);
/*  95 */     this.body3.addBox(-8.0F, 0.0F, 0.0F, 16, 6, 11);
/*  96 */     this.body3.setRotationPoint(0.0F, 3.0F, 6.0F);
/*  97 */     this.body3.setTextureSize(128, 128);
/*  98 */     this.body3.mirror = true;
/*  99 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/* 100 */     this.guard = new ModelRenderer(this, 60, 34);
/* 101 */     this.guard.addBox(-14.0F, -20.0F, -8.0F, 28, 23, 3);
/* 102 */     this.guard.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 103 */     this.guard.setTextureSize(128, 128);
/* 104 */     this.guard.mirror = true;
/* 105 */     setRotation(this.guard, -0.2617994F, 0.0F, 0.0F);
/* 106 */     this.nose = new ModelRenderer(this, 39, 0);
/* 107 */     this.nose.addBox(-5.0F, -9.0F, -15.0F, 10, 6, 5);
/* 108 */     this.nose.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 109 */     this.nose.setTextureSize(128, 128);
/* 110 */     this.nose.mirror = true;
/* 111 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/* 112 */     this.lhorn = new ModelRenderer(this, 0, 18);
/* 113 */     this.lhorn.addBox(8.0F, -16.0F, -29.0F, 2, 2, 23);
/* 114 */     this.lhorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 115 */     this.lhorn.setTextureSize(128, 128);
/* 116 */     this.lhorn.mirror = true;
/* 117 */     setRotation(this.lhorn, -0.1570796F, -0.1396263F, 0.0F);
/* 118 */     this.rhorn = new ModelRenderer(this, 0, 18);
/* 119 */     this.rhorn.addBox(-9.0F, -16.0F, -29.0F, 2, 2, 23);
/* 120 */     this.rhorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 121 */     this.rhorn.setTextureSize(128, 128);
/* 122 */     this.rhorn.mirror = true;
/* 123 */     setRotation(this.rhorn, -0.1570796F, 0.1396263F, 0.0F);
/* 124 */     this.chorn = new ModelRenderer(this, 52, 13);
/* 125 */     this.chorn.addBox(-1.5F, -9.0F, -20.0F, 3, 3, 5);
/* 126 */     this.chorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 127 */     this.chorn.setTextureSize(128, 128);
/* 128 */     this.chorn.mirror = true;
/* 129 */     setRotation(this.chorn, 0.0F, 0.0F, 0.0F);
/* 130 */     this.tail = new ModelRenderer(this, 68, 70);
/* 131 */     this.tail.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 9);
/* 132 */     this.tail.setRotationPoint(0.0F, 7.0F, 15.0F);
/* 133 */     this.tail.setTextureSize(128, 128);
/* 134 */     this.tail.mirror = true;
/* 135 */     setRotation(this.tail, 0.2792527F, 0.0F, 0.0F);
/* 136 */     this.bump1 = new ModelRenderer(this, 57, 17);
/* 137 */     this.bump1.addBox(14.0F, -20.0F, -8.0F, 2, 2, 2);
/* 138 */     this.bump1.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 139 */     this.bump1.setTextureSize(128, 128);
/* 140 */     this.bump1.mirror = true;
/* 141 */     setRotation(this.bump1, -0.2617994F, 0.0F, 0.0F);
/* 142 */     this.bump2 = new ModelRenderer(this, 57, 17);
/* 143 */     this.bump2.addBox(14.0F, -15.0F, -8.0F, 2, 2, 2);
/* 144 */     this.bump2.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 145 */     this.bump2.setTextureSize(128, 128);
/* 146 */     this.bump2.mirror = true;
/* 147 */     setRotation(this.bump2, -0.2617994F, 0.0F, 0.0F);
/* 148 */     this.bump3 = new ModelRenderer(this, 57, 17);
/* 149 */     this.bump3.addBox(14.0F, -10.0F, -8.0F, 2, 2, 2);
/* 150 */     this.bump3.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 151 */     this.bump3.setTextureSize(128, 128);
/* 152 */     this.bump3.mirror = true;
/* 153 */     setRotation(this.bump3, -0.2617994F, 0.0F, 0.0F);
/* 154 */     this.bump4 = new ModelRenderer(this, 57, 17);
/* 155 */     this.bump4.addBox(14.0F, -5.0F, -8.0F, 2, 2, 2);
/* 156 */     this.bump4.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 157 */     this.bump4.setTextureSize(128, 128);
/* 158 */     this.bump4.mirror = true;
/* 159 */     setRotation(this.bump4, -0.2617994F, 0.0F, 0.0F);
/* 160 */     this.bump5 = new ModelRenderer(this, 57, 17);
/* 161 */     this.bump5.addBox(14.0F, 0.0F, -8.0F, 2, 2, 2);
/* 162 */     this.bump5.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 163 */     this.bump5.setTextureSize(128, 128);
/* 164 */     this.bump5.mirror = true;
/* 165 */     setRotation(this.bump5, -0.2617994F, 0.0F, 0.0F);
/* 166 */     this.bump6 = new ModelRenderer(this, 57, 17);
/* 167 */     this.bump6.addBox(-16.0F, -20.0F, -8.0F, 2, 2, 2);
/* 168 */     this.bump6.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 169 */     this.bump6.setTextureSize(128, 128);
/* 170 */     this.bump6.mirror = true;
/* 171 */     setRotation(this.bump6, -0.2617994F, 0.0F, 0.0F);
/* 172 */     this.bump7 = new ModelRenderer(this, 57, 17);
/* 173 */     this.bump7.addBox(-16.0F, -15.0F, -8.0F, 2, 2, 2);
/* 174 */     this.bump7.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 175 */     this.bump7.setTextureSize(128, 128);
/* 176 */     this.bump7.mirror = true;
/* 177 */     setRotation(this.bump7, -0.2617994F, 0.0F, 0.0F);
/* 178 */     this.bump8 = new ModelRenderer(this, 57, 17);
/* 179 */     this.bump8.addBox(-16.0F, -10.0F, -8.0F, 2, 2, 2);
/* 180 */     this.bump8.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 181 */     this.bump8.setTextureSize(128, 128);
/* 182 */     this.bump8.mirror = true;
/* 183 */     setRotation(this.bump8, -0.2617994F, 0.0F, 0.0F);
/* 184 */     this.bump9 = new ModelRenderer(this, 57, 17);
/* 185 */     this.bump9.addBox(-16.0F, -5.0F, -8.0F, 2, 2, 2);
/* 186 */     this.bump9.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 187 */     this.bump9.setTextureSize(128, 128);
/* 188 */     this.bump9.mirror = true;
/* 189 */     setRotation(this.bump9, -0.2617994F, 0.0F, 0.0F);
/* 190 */     this.bump10 = new ModelRenderer(this, 57, 17);
/* 191 */     this.bump10.addBox(-16.0F, 0.0F, -8.0F, 2, 2, 2);
/* 192 */     this.bump10.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 193 */     this.bump10.setTextureSize(128, 128);
/* 194 */     this.bump10.mirror = true;
/* 195 */     setRotation(this.bump10, -0.2617994F, 0.0F, 0.0F);
/* 196 */     this.bump11 = new ModelRenderer(this, 57, 17);
/* 197 */     this.bump11.addBox(12.0F, -22.0F, -8.0F, 2, 2, 2);
/* 198 */     this.bump11.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 199 */     this.bump11.setTextureSize(128, 128);
/* 200 */     this.bump11.mirror = true;
/* 201 */     setRotation(this.bump11, -0.2617994F, 0.0F, 0.0F);
/* 202 */     this.bump12 = new ModelRenderer(this, 57, 17);
/* 203 */     this.bump12.addBox(7.0F, -22.0F, -8.0F, 2, 2, 2);
/* 204 */     this.bump12.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 205 */     this.bump12.setTextureSize(128, 128);
/* 206 */     this.bump12.mirror = true;
/* 207 */     setRotation(this.bump12, -0.2617994F, 0.0F, 0.0F);
/* 208 */     this.bump13 = new ModelRenderer(this, 57, 17);
/* 209 */     this.bump13.addBox(2.0F, -22.0F, -8.0F, 2, 2, 2);
/* 210 */     this.bump13.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 211 */     this.bump13.setTextureSize(128, 128);
/* 212 */     this.bump13.mirror = true;
/* 213 */     setRotation(this.bump13, -0.2617994F, 0.0F, 0.0F);
/* 214 */     this.bump14 = new ModelRenderer(this, 57, 17);
/* 215 */     this.bump14.addBox(-4.0F, -22.0F, -8.0F, 2, 2, 2);
/* 216 */     this.bump14.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 217 */     this.bump14.setTextureSize(128, 128);
/* 218 */     this.bump14.mirror = true;
/* 219 */     setRotation(this.bump14, -0.2617994F, 0.0F, 0.0F);
/* 220 */     this.bump15 = new ModelRenderer(this, 57, 17);
/* 221 */     this.bump15.addBox(-9.0F, -22.0F, -8.0F, 2, 2, 2);
/* 222 */     this.bump15.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 223 */     this.bump15.setTextureSize(128, 128);
/* 224 */     this.bump15.mirror = true;
/* 225 */     setRotation(this.bump15, -0.2617994F, 0.0F, 0.0F);
/* 226 */     this.bump16 = new ModelRenderer(this, 57, 17);
/* 227 */     this.bump16.addBox(-14.0F, -22.0F, -8.0F, 2, 2, 2);
/* 228 */     this.bump16.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 229 */     this.bump16.setTextureSize(128, 128);
/* 230 */     this.bump16.mirror = true;
/* 231 */     setRotation(this.bump16, -0.2617994F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 237 */     Pointysaurus e = (Pointysaurus)entity;
/* 238 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 239 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 240 */     float newangle = 0.0F;
/*     */     
/* 242 */     if (f1 > 0.1D) {
/* 243 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 245 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 248 */     this.lfleg.rotateAngleX = newangle;
/* 249 */     this.rrleg.rotateAngleX = newangle;
/* 250 */     this.rfleg.rotateAngleX = -newangle;
/* 251 */     this.lrleg.rotateAngleX = -newangle;
/*     */     
/* 253 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 254 */     this.nose.rotateAngleY = this.head.rotateAngleY;
/* 255 */     this.chorn.rotateAngleY = this.head.rotateAngleY;
/* 256 */     this.head.rotateAngleY -= 0.14F;
/* 257 */     this.head.rotateAngleY += 0.14F;
/* 258 */     this.guard.rotateAngleY = this.head.rotateAngleY;
/* 259 */     this.bump1.rotateAngleY = this.head.rotateAngleY;
/* 260 */     this.bump2.rotateAngleY = this.head.rotateAngleY;
/* 261 */     this.bump3.rotateAngleY = this.head.rotateAngleY;
/* 262 */     this.bump4.rotateAngleY = this.head.rotateAngleY;
/* 263 */     this.bump5.rotateAngleY = this.head.rotateAngleY;
/* 264 */     this.bump6.rotateAngleY = this.head.rotateAngleY;
/* 265 */     this.bump7.rotateAngleY = this.head.rotateAngleY;
/* 266 */     this.bump8.rotateAngleY = this.head.rotateAngleY;
/* 267 */     this.bump9.rotateAngleY = this.head.rotateAngleY;
/* 268 */     this.bump10.rotateAngleY = this.head.rotateAngleY;
/* 269 */     this.bump11.rotateAngleY = this.head.rotateAngleY;
/* 270 */     this.bump12.rotateAngleY = this.head.rotateAngleY;
/* 271 */     this.bump13.rotateAngleY = this.head.rotateAngleY;
/* 272 */     this.bump14.rotateAngleY = this.head.rotateAngleY;
/* 273 */     this.bump15.rotateAngleY = this.head.rotateAngleY;
/* 274 */     this.bump16.rotateAngleY = this.head.rotateAngleY;
/*     */     
/* 276 */     this.head.rotateAngleX = (float)Math.toRadians(f4) * 0.45F;
/* 277 */     this.nose.rotateAngleX = this.head.rotateAngleX;
/* 278 */     this.chorn.rotateAngleX = this.head.rotateAngleX;
/* 279 */     this.head.rotateAngleX -= 0.16F;
/* 280 */     this.head.rotateAngleX -= 0.16F;
/* 281 */     this.head.rotateAngleX -= 0.262F;
/* 282 */     this.bump1.rotateAngleX = this.guard.rotateAngleX;
/* 283 */     this.bump2.rotateAngleX = this.guard.rotateAngleX;
/* 284 */     this.bump3.rotateAngleX = this.guard.rotateAngleX;
/* 285 */     this.bump4.rotateAngleX = this.guard.rotateAngleX;
/* 286 */     this.bump5.rotateAngleX = this.guard.rotateAngleX;
/* 287 */     this.bump6.rotateAngleX = this.guard.rotateAngleX;
/* 288 */     this.bump7.rotateAngleX = this.guard.rotateAngleX;
/* 289 */     this.bump8.rotateAngleX = this.guard.rotateAngleX;
/* 290 */     this.bump9.rotateAngleX = this.guard.rotateAngleX;
/* 291 */     this.bump10.rotateAngleX = this.guard.rotateAngleX;
/* 292 */     this.bump11.rotateAngleX = this.guard.rotateAngleX;
/* 293 */     this.bump12.rotateAngleX = this.guard.rotateAngleX;
/* 294 */     this.bump13.rotateAngleX = this.guard.rotateAngleX;
/* 295 */     this.bump14.rotateAngleX = this.guard.rotateAngleX;
/* 296 */     this.bump15.rotateAngleX = this.guard.rotateAngleX;
/* 297 */     this.bump16.rotateAngleX = this.guard.rotateAngleX;
/*     */     
/* 299 */     if (e.getAttacking() != 0) {
/* 300 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/*     */     } else {
/* 302 */       newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.05F;
/*     */     } 
/* 304 */     this.tail.rotateAngleY = newangle;
/*     */     
/* 306 */     newangle = MathHelper.cos(f2 * 0.02F * this.wingspeed) * 3.1415927F * 0.15F;
/* 307 */     this.tail.rotateAngleX = newangle + 0.28F;
/*     */ 
/*     */     
/* 310 */     this.lfleg.render(f5);
/* 311 */     this.rfleg.render(f5);
/* 312 */     this.lrleg.render(f5);
/* 313 */     this.rrleg.render(f5);
/* 314 */     this.body1.render(f5);
/* 315 */     this.head.render(f5);
/* 316 */     this.body2.render(f5);
/* 317 */     this.body3.render(f5);
/* 318 */     this.guard.render(f5);
/* 319 */     this.nose.render(f5);
/* 320 */     this.lhorn.render(f5);
/* 321 */     this.rhorn.render(f5);
/* 322 */     this.chorn.render(f5);
/* 323 */     this.tail.render(f5);
/* 324 */     this.bump1.render(f5);
/* 325 */     this.bump2.render(f5);
/* 326 */     this.bump3.render(f5);
/* 327 */     this.bump4.render(f5);
/* 328 */     this.bump5.render(f5);
/* 329 */     this.bump6.render(f5);
/* 330 */     this.bump7.render(f5);
/* 331 */     this.bump8.render(f5);
/* 332 */     this.bump9.render(f5);
/* 333 */     this.bump10.render(f5);
/* 334 */     this.bump11.render(f5);
/* 335 */     this.bump12.render(f5);
/* 336 */     this.bump13.render(f5);
/* 337 */     this.bump14.render(f5);
/* 338 */     this.bump15.render(f5);
/* 339 */     this.bump16.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 345 */     model.rotateAngleX = x;
/* 346 */     model.rotateAngleY = y;
/* 347 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 352 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelPointysaurus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */