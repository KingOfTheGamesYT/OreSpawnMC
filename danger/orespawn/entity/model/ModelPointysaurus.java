/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Pointysaurus;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelPointysaurus
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
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
/*  48 */     this.wingspeed = f1;
/*     */     
/*  50 */     this.textureWidth = 128;
/*  51 */     this.textureHeight = 128;
/*     */     
/*  53 */     this.lfleg = new ModelRenderer(this, 102, 66);
/*  54 */     this.lfleg.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/*  55 */     this.lfleg.setRotationPoint(9.0F, 16.0F, -8.0F);
/*  56 */     this.lfleg.setTextureSize(128, 128);
/*  57 */     this.lfleg.mirror = true;
/*  58 */     setRotation(this.lfleg, 0.0F, 0.0F, 0.0F);
/*  59 */     this.rfleg = new ModelRenderer(this, 102, 66);
/*  60 */     this.rfleg.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/*  61 */     this.rfleg.setRotationPoint(-9.0F, 16.0F, -8.0F);
/*  62 */     this.rfleg.setTextureSize(128, 128);
/*  63 */     this.rfleg.mirror = true;
/*  64 */     setRotation(this.rfleg, 0.0F, 0.0F, 0.0F);
/*  65 */     this.lrleg = new ModelRenderer(this, 0, 0);
/*  66 */     this.lrleg.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
/*  67 */     this.lrleg.setRotationPoint(9.0F, 16.0F, 12.0F);
/*  68 */     this.lrleg.setTextureSize(128, 128);
/*  69 */     this.lrleg.mirror = true;
/*  70 */     setRotation(this.lrleg, 0.0F, 0.0F, 0.0F);
/*  71 */     this.rrleg = new ModelRenderer(this, 0, 0);
/*  72 */     this.rrleg.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
/*  73 */     this.rrleg.setRotationPoint(-9.0F, 16.0F, 12.0F);
/*  74 */     this.rrleg.setTextureSize(128, 128);
/*  75 */     this.rrleg.mirror = true;
/*  76 */     setRotation(this.rrleg, 0.0F, 0.0F, 0.0F);
/*  77 */     this.body1 = new ModelRenderer(this, 0, 87);
/*  78 */     this.body1.addBox(-4.0F, 0.0F, 0.0F, 22, 9, 30);
/*  79 */     this.body1.setRotationPoint(-7.0F, 9.0F, -12.0F);
/*  80 */     this.body1.setTextureSize(128, 128);
/*  81 */     this.body1.mirror = true;
/*  82 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/*  83 */     this.head = new ModelRenderer(this, 70, 0);
/*  84 */     this.head.addBox(-6.0F, -10.0F, -12.0F, 12, 10, 12);
/*  85 */     this.head.setRotationPoint(0.0F, 11.0F, -7.0F);
/*  86 */     this.head.setTextureSize(128, 128);
/*  87 */     this.head.mirror = true;
/*  88 */     setRotation(this.head, -0.1919862F, 0.0F, 0.0F);
/*  89 */     this.body2 = new ModelRenderer(this, 0, 63);
/*  90 */     this.body2.addBox(-9.0F, 0.0F, 0.0F, 18, 7, 15);
/*  91 */     this.body2.setRotationPoint(0.0F, 2.0F, -9.0F);
/*  92 */     this.body2.setTextureSize(128, 128);
/*  93 */     this.body2.mirror = true;
/*  94 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  95 */     this.body3 = new ModelRenderer(this, 0, 44);
/*  96 */     this.body3.addBox(-8.0F, 0.0F, 0.0F, 16, 6, 11);
/*  97 */     this.body3.setRotationPoint(0.0F, 3.0F, 6.0F);
/*  98 */     this.body3.setTextureSize(128, 128);
/*  99 */     this.body3.mirror = true;
/* 100 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/* 101 */     this.guard = new ModelRenderer(this, 60, 34);
/* 102 */     this.guard.addBox(-14.0F, -20.0F, -8.0F, 28, 23, 3);
/* 103 */     this.guard.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 104 */     this.guard.setTextureSize(128, 128);
/* 105 */     this.guard.mirror = true;
/* 106 */     setRotation(this.guard, -0.2617994F, 0.0F, 0.0F);
/* 107 */     this.nose = new ModelRenderer(this, 39, 0);
/* 108 */     this.nose.addBox(-5.0F, -9.0F, -15.0F, 10, 6, 5);
/* 109 */     this.nose.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 110 */     this.nose.setTextureSize(128, 128);
/* 111 */     this.nose.mirror = true;
/* 112 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/* 113 */     this.lhorn = new ModelRenderer(this, 0, 18);
/* 114 */     this.lhorn.addBox(8.0F, -16.0F, -29.0F, 2, 2, 23);
/* 115 */     this.lhorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 116 */     this.lhorn.setTextureSize(128, 128);
/* 117 */     this.lhorn.mirror = true;
/* 118 */     setRotation(this.lhorn, -0.1570796F, -0.1396263F, 0.0F);
/* 119 */     this.rhorn = new ModelRenderer(this, 0, 18);
/* 120 */     this.rhorn.addBox(-9.0F, -16.0F, -29.0F, 2, 2, 23);
/* 121 */     this.rhorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 122 */     this.rhorn.setTextureSize(128, 128);
/* 123 */     this.rhorn.mirror = true;
/* 124 */     setRotation(this.rhorn, -0.1570796F, 0.1396263F, 0.0F);
/* 125 */     this.chorn = new ModelRenderer(this, 52, 13);
/* 126 */     this.chorn.addBox(-1.5F, -9.0F, -20.0F, 3, 3, 5);
/* 127 */     this.chorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 128 */     this.chorn.setTextureSize(128, 128);
/* 129 */     this.chorn.mirror = true;
/* 130 */     setRotation(this.chorn, 0.0F, 0.0F, 0.0F);
/* 131 */     this.tail = new ModelRenderer(this, 68, 70);
/* 132 */     this.tail.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 9);
/* 133 */     this.tail.setRotationPoint(0.0F, 7.0F, 15.0F);
/* 134 */     this.tail.setTextureSize(128, 128);
/* 135 */     this.tail.mirror = true;
/* 136 */     setRotation(this.tail, 0.2792527F, 0.0F, 0.0F);
/* 137 */     this.bump1 = new ModelRenderer(this, 57, 17);
/* 138 */     this.bump1.addBox(14.0F, -20.0F, -8.0F, 2, 2, 2);
/* 139 */     this.bump1.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 140 */     this.bump1.setTextureSize(128, 128);
/* 141 */     this.bump1.mirror = true;
/* 142 */     setRotation(this.bump1, -0.2617994F, 0.0F, 0.0F);
/* 143 */     this.bump2 = new ModelRenderer(this, 57, 17);
/* 144 */     this.bump2.addBox(14.0F, -15.0F, -8.0F, 2, 2, 2);
/* 145 */     this.bump2.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 146 */     this.bump2.setTextureSize(128, 128);
/* 147 */     this.bump2.mirror = true;
/* 148 */     setRotation(this.bump2, -0.2617994F, 0.0F, 0.0F);
/* 149 */     this.bump3 = new ModelRenderer(this, 57, 17);
/* 150 */     this.bump3.addBox(14.0F, -10.0F, -8.0F, 2, 2, 2);
/* 151 */     this.bump3.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 152 */     this.bump3.setTextureSize(128, 128);
/* 153 */     this.bump3.mirror = true;
/* 154 */     setRotation(this.bump3, -0.2617994F, 0.0F, 0.0F);
/* 155 */     this.bump4 = new ModelRenderer(this, 57, 17);
/* 156 */     this.bump4.addBox(14.0F, -5.0F, -8.0F, 2, 2, 2);
/* 157 */     this.bump4.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 158 */     this.bump4.setTextureSize(128, 128);
/* 159 */     this.bump4.mirror = true;
/* 160 */     setRotation(this.bump4, -0.2617994F, 0.0F, 0.0F);
/* 161 */     this.bump5 = new ModelRenderer(this, 57, 17);
/* 162 */     this.bump5.addBox(14.0F, 0.0F, -8.0F, 2, 2, 2);
/* 163 */     this.bump5.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 164 */     this.bump5.setTextureSize(128, 128);
/* 165 */     this.bump5.mirror = true;
/* 166 */     setRotation(this.bump5, -0.2617994F, 0.0F, 0.0F);
/* 167 */     this.bump6 = new ModelRenderer(this, 57, 17);
/* 168 */     this.bump6.addBox(-16.0F, -20.0F, -8.0F, 2, 2, 2);
/* 169 */     this.bump6.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 170 */     this.bump6.setTextureSize(128, 128);
/* 171 */     this.bump6.mirror = true;
/* 172 */     setRotation(this.bump6, -0.2617994F, 0.0F, 0.0F);
/* 173 */     this.bump7 = new ModelRenderer(this, 57, 17);
/* 174 */     this.bump7.addBox(-16.0F, -15.0F, -8.0F, 2, 2, 2);
/* 175 */     this.bump7.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 176 */     this.bump7.setTextureSize(128, 128);
/* 177 */     this.bump7.mirror = true;
/* 178 */     setRotation(this.bump7, -0.2617994F, 0.0F, 0.0F);
/* 179 */     this.bump8 = new ModelRenderer(this, 57, 17);
/* 180 */     this.bump8.addBox(-16.0F, -10.0F, -8.0F, 2, 2, 2);
/* 181 */     this.bump8.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 182 */     this.bump8.setTextureSize(128, 128);
/* 183 */     this.bump8.mirror = true;
/* 184 */     setRotation(this.bump8, -0.2617994F, 0.0F, 0.0F);
/* 185 */     this.bump9 = new ModelRenderer(this, 57, 17);
/* 186 */     this.bump9.addBox(-16.0F, -5.0F, -8.0F, 2, 2, 2);
/* 187 */     this.bump9.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 188 */     this.bump9.setTextureSize(128, 128);
/* 189 */     this.bump9.mirror = true;
/* 190 */     setRotation(this.bump9, -0.2617994F, 0.0F, 0.0F);
/* 191 */     this.bump10 = new ModelRenderer(this, 57, 17);
/* 192 */     this.bump10.addBox(-16.0F, 0.0F, -8.0F, 2, 2, 2);
/* 193 */     this.bump10.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 194 */     this.bump10.setTextureSize(128, 128);
/* 195 */     this.bump10.mirror = true;
/* 196 */     setRotation(this.bump10, -0.2617994F, 0.0F, 0.0F);
/* 197 */     this.bump11 = new ModelRenderer(this, 57, 17);
/* 198 */     this.bump11.addBox(12.0F, -22.0F, -8.0F, 2, 2, 2);
/* 199 */     this.bump11.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 200 */     this.bump11.setTextureSize(128, 128);
/* 201 */     this.bump11.mirror = true;
/* 202 */     setRotation(this.bump11, -0.2617994F, 0.0F, 0.0F);
/* 203 */     this.bump12 = new ModelRenderer(this, 57, 17);
/* 204 */     this.bump12.addBox(7.0F, -22.0F, -8.0F, 2, 2, 2);
/* 205 */     this.bump12.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 206 */     this.bump12.setTextureSize(128, 128);
/* 207 */     this.bump12.mirror = true;
/* 208 */     setRotation(this.bump12, -0.2617994F, 0.0F, 0.0F);
/* 209 */     this.bump13 = new ModelRenderer(this, 57, 17);
/* 210 */     this.bump13.addBox(2.0F, -22.0F, -8.0F, 2, 2, 2);
/* 211 */     this.bump13.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 212 */     this.bump13.setTextureSize(128, 128);
/* 213 */     this.bump13.mirror = true;
/* 214 */     setRotation(this.bump13, -0.2617994F, 0.0F, 0.0F);
/* 215 */     this.bump14 = new ModelRenderer(this, 57, 17);
/* 216 */     this.bump14.addBox(-4.0F, -22.0F, -8.0F, 2, 2, 2);
/* 217 */     this.bump14.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 218 */     this.bump14.setTextureSize(128, 128);
/* 219 */     this.bump14.mirror = true;
/* 220 */     setRotation(this.bump14, -0.2617994F, 0.0F, 0.0F);
/* 221 */     this.bump15 = new ModelRenderer(this, 57, 17);
/* 222 */     this.bump15.addBox(-9.0F, -22.0F, -8.0F, 2, 2, 2);
/* 223 */     this.bump15.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 224 */     this.bump15.setTextureSize(128, 128);
/* 225 */     this.bump15.mirror = true;
/* 226 */     setRotation(this.bump15, -0.2617994F, 0.0F, 0.0F);
/* 227 */     this.bump16 = new ModelRenderer(this, 57, 17);
/* 228 */     this.bump16.addBox(-14.0F, -22.0F, -8.0F, 2, 2, 2);
/* 229 */     this.bump16.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 230 */     this.bump16.setTextureSize(128, 128);
/* 231 */     this.bump16.mirror = true;
/* 232 */     setRotation(this.bump16, -0.2617994F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 238 */     Pointysaurus e = (Pointysaurus)entity;
/* 239 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 240 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 241 */     float newangle = 0.0F;
/*     */     
/* 243 */     if (f1 > 0.1D) {
/* 244 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 246 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 249 */     this.lfleg.rotateAngleX = newangle;
/* 250 */     this.rrleg.rotateAngleX = newangle;
/* 251 */     this.rfleg.rotateAngleX = -newangle;
/* 252 */     this.lrleg.rotateAngleX = -newangle;
/*     */     
/* 254 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 255 */     this.nose.rotateAngleY = this.head.rotateAngleY;
/* 256 */     this.chorn.rotateAngleY = this.head.rotateAngleY;
/* 257 */     this.head.rotateAngleY -= 0.14F;
/* 258 */     this.head.rotateAngleY += 0.14F;
/* 259 */     this.guard.rotateAngleY = this.head.rotateAngleY;
/* 260 */     this.bump1.rotateAngleY = this.head.rotateAngleY;
/* 261 */     this.bump2.rotateAngleY = this.head.rotateAngleY;
/* 262 */     this.bump3.rotateAngleY = this.head.rotateAngleY;
/* 263 */     this.bump4.rotateAngleY = this.head.rotateAngleY;
/* 264 */     this.bump5.rotateAngleY = this.head.rotateAngleY;
/* 265 */     this.bump6.rotateAngleY = this.head.rotateAngleY;
/* 266 */     this.bump7.rotateAngleY = this.head.rotateAngleY;
/* 267 */     this.bump8.rotateAngleY = this.head.rotateAngleY;
/* 268 */     this.bump9.rotateAngleY = this.head.rotateAngleY;
/* 269 */     this.bump10.rotateAngleY = this.head.rotateAngleY;
/* 270 */     this.bump11.rotateAngleY = this.head.rotateAngleY;
/* 271 */     this.bump12.rotateAngleY = this.head.rotateAngleY;
/* 272 */     this.bump13.rotateAngleY = this.head.rotateAngleY;
/* 273 */     this.bump14.rotateAngleY = this.head.rotateAngleY;
/* 274 */     this.bump15.rotateAngleY = this.head.rotateAngleY;
/* 275 */     this.bump16.rotateAngleY = this.head.rotateAngleY;
/*     */     
/* 277 */     this.head.rotateAngleX = (float)Math.toRadians(f4) * 0.45F;
/* 278 */     this.nose.rotateAngleX = this.head.rotateAngleX;
/* 279 */     this.chorn.rotateAngleX = this.head.rotateAngleX;
/* 280 */     this.head.rotateAngleX -= 0.16F;
/* 281 */     this.head.rotateAngleX -= 0.16F;
/* 282 */     this.head.rotateAngleX -= 0.262F;
/* 283 */     this.bump1.rotateAngleX = this.guard.rotateAngleX;
/* 284 */     this.bump2.rotateAngleX = this.guard.rotateAngleX;
/* 285 */     this.bump3.rotateAngleX = this.guard.rotateAngleX;
/* 286 */     this.bump4.rotateAngleX = this.guard.rotateAngleX;
/* 287 */     this.bump5.rotateAngleX = this.guard.rotateAngleX;
/* 288 */     this.bump6.rotateAngleX = this.guard.rotateAngleX;
/* 289 */     this.bump7.rotateAngleX = this.guard.rotateAngleX;
/* 290 */     this.bump8.rotateAngleX = this.guard.rotateAngleX;
/* 291 */     this.bump9.rotateAngleX = this.guard.rotateAngleX;
/* 292 */     this.bump10.rotateAngleX = this.guard.rotateAngleX;
/* 293 */     this.bump11.rotateAngleX = this.guard.rotateAngleX;
/* 294 */     this.bump12.rotateAngleX = this.guard.rotateAngleX;
/* 295 */     this.bump13.rotateAngleX = this.guard.rotateAngleX;
/* 296 */     this.bump14.rotateAngleX = this.guard.rotateAngleX;
/* 297 */     this.bump15.rotateAngleX = this.guard.rotateAngleX;
/* 298 */     this.bump16.rotateAngleX = this.guard.rotateAngleX;
/*     */     
/* 300 */     if (e.getAttacking() != 0) {
/* 301 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F;
/*     */     } else {
/* 303 */       newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.05F;
/*     */     } 
/* 305 */     this.tail.rotateAngleY = newangle;
/*     */     
/* 307 */     newangle = MathHelper.cos(f2 * 0.02F * this.wingspeed) * 3.1415927F * 0.15F;
/* 308 */     this.tail.rotateAngleX = newangle + 0.28F;
/*     */ 
/*     */     
/* 311 */     this.lfleg.render(f5);
/* 312 */     this.rfleg.render(f5);
/* 313 */     this.lrleg.render(f5);
/* 314 */     this.rrleg.render(f5);
/* 315 */     this.body1.render(f5);
/* 316 */     this.head.render(f5);
/* 317 */     this.body2.render(f5);
/* 318 */     this.body3.render(f5);
/* 319 */     this.guard.render(f5);
/* 320 */     this.nose.render(f5);
/* 321 */     this.lhorn.render(f5);
/* 322 */     this.rhorn.render(f5);
/* 323 */     this.chorn.render(f5);
/* 324 */     this.tail.render(f5);
/* 325 */     this.bump1.render(f5);
/* 326 */     this.bump2.render(f5);
/* 327 */     this.bump3.render(f5);
/* 328 */     this.bump4.render(f5);
/* 329 */     this.bump5.render(f5);
/* 330 */     this.bump6.render(f5);
/* 331 */     this.bump7.render(f5);
/* 332 */     this.bump8.render(f5);
/* 333 */     this.bump9.render(f5);
/* 334 */     this.bump10.render(f5);
/* 335 */     this.bump11.render(f5);
/* 336 */     this.bump12.render(f5);
/* 337 */     this.bump13.render(f5);
/* 338 */     this.bump14.render(f5);
/* 339 */     this.bump15.render(f5);
/* 340 */     this.bump16.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 346 */     model.rotateAngleX = x;
/* 347 */     model.rotateAngleY = y;
/* 348 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 353 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\entity\model\ModelPointysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */