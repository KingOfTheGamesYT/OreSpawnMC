/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Pointysaurus;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelPointysaurus
/*     */   extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer lfleg;
/*     */   
/*     */   ModelRenderer rfleg;
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
/*  46 */     this.wingspeed = f1;
/*     */     
/*  48 */     this.textureWidth = 128;
/*  49 */     this.textureHeight = 128;
/*     */     
/*  51 */     this.lfleg = new ModelRenderer(this, 102, 66);
/*  52 */     this.lfleg.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/*  53 */     this.lfleg.setRotationPoint(9.0F, 16.0F, -8.0F);
/*  54 */     this.lfleg.setTextureSize(128, 128);
/*  55 */     this.lfleg.mirror = true;
/*  56 */     setRotation(this.lfleg, 0.0F, 0.0F, 0.0F);
/*  57 */     this.rfleg = new ModelRenderer(this, 102, 66);
/*  58 */     this.rfleg.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6);
/*  59 */     this.rfleg.setRotationPoint(-9.0F, 16.0F, -8.0F);
/*  60 */     this.rfleg.setTextureSize(128, 128);
/*  61 */     this.rfleg.mirror = true;
/*  62 */     setRotation(this.rfleg, 0.0F, 0.0F, 0.0F);
/*  63 */     this.lrleg = new ModelRenderer(this, 0, 0);
/*  64 */     this.lrleg.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
/*  65 */     this.lrleg.setRotationPoint(9.0F, 16.0F, 12.0F);
/*  66 */     this.lrleg.setTextureSize(128, 128);
/*  67 */     this.lrleg.mirror = true;
/*  68 */     setRotation(this.lrleg, 0.0F, 0.0F, 0.0F);
/*  69 */     this.rrleg = new ModelRenderer(this, 0, 0);
/*  70 */     this.rrleg.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
/*  71 */     this.rrleg.setRotationPoint(-9.0F, 16.0F, 12.0F);
/*  72 */     this.rrleg.setTextureSize(128, 128);
/*  73 */     this.rrleg.mirror = true;
/*  74 */     setRotation(this.rrleg, 0.0F, 0.0F, 0.0F);
/*  75 */     this.body1 = new ModelRenderer(this, 0, 87);
/*  76 */     this.body1.addBox(-4.0F, 0.0F, 0.0F, 22, 9, 30);
/*  77 */     this.body1.setRotationPoint(-7.0F, 9.0F, -12.0F);
/*  78 */     this.body1.setTextureSize(128, 128);
/*  79 */     this.body1.mirror = true;
/*  80 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/*  81 */     this.head = new ModelRenderer(this, 70, 0);
/*  82 */     this.head.addBox(-6.0F, -10.0F, -12.0F, 12, 10, 12);
/*  83 */     this.head.setRotationPoint(0.0F, 11.0F, -7.0F);
/*  84 */     this.head.setTextureSize(128, 128);
/*  85 */     this.head.mirror = true;
/*  86 */     setRotation(this.head, -0.1919862F, 0.0F, 0.0F);
/*  87 */     this.body2 = new ModelRenderer(this, 0, 63);
/*  88 */     this.body2.addBox(-9.0F, 0.0F, 0.0F, 18, 7, 15);
/*  89 */     this.body2.setRotationPoint(0.0F, 2.0F, -9.0F);
/*  90 */     this.body2.setTextureSize(128, 128);
/*  91 */     this.body2.mirror = true;
/*  92 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  93 */     this.body3 = new ModelRenderer(this, 0, 44);
/*  94 */     this.body3.addBox(-8.0F, 0.0F, 0.0F, 16, 6, 11);
/*  95 */     this.body3.setRotationPoint(0.0F, 3.0F, 6.0F);
/*  96 */     this.body3.setTextureSize(128, 128);
/*  97 */     this.body3.mirror = true;
/*  98 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/*  99 */     this.guard = new ModelRenderer(this, 60, 34);
/* 100 */     this.guard.addBox(-14.0F, -20.0F, -8.0F, 28, 23, 3);
/* 101 */     this.guard.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 102 */     this.guard.setTextureSize(128, 128);
/* 103 */     this.guard.mirror = true;
/* 104 */     setRotation(this.guard, -0.2617994F, 0.0F, 0.0F);
/* 105 */     this.nose = new ModelRenderer(this, 39, 0);
/* 106 */     this.nose.addBox(-5.0F, -9.0F, -15.0F, 10, 6, 5);
/* 107 */     this.nose.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 108 */     this.nose.setTextureSize(128, 128);
/* 109 */     this.nose.mirror = true;
/* 110 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/* 111 */     this.lhorn = new ModelRenderer(this, 0, 18);
/* 112 */     this.lhorn.addBox(8.0F, -16.0F, -29.0F, 2, 2, 23);
/* 113 */     this.lhorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 114 */     this.lhorn.setTextureSize(128, 128);
/* 115 */     this.lhorn.mirror = true;
/* 116 */     setRotation(this.lhorn, -0.1570796F, -0.1396263F, 0.0F);
/* 117 */     this.rhorn = new ModelRenderer(this, 0, 18);
/* 118 */     this.rhorn.addBox(-9.0F, -16.0F, -29.0F, 2, 2, 23);
/* 119 */     this.rhorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 120 */     this.rhorn.setTextureSize(128, 128);
/* 121 */     this.rhorn.mirror = true;
/* 122 */     setRotation(this.rhorn, -0.1570796F, 0.1396263F, 0.0F);
/* 123 */     this.chorn = new ModelRenderer(this, 52, 13);
/* 124 */     this.chorn.addBox(-1.5F, -9.0F, -20.0F, 3, 3, 5);
/* 125 */     this.chorn.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 126 */     this.chorn.setTextureSize(128, 128);
/* 127 */     this.chorn.mirror = true;
/* 128 */     setRotation(this.chorn, 0.0F, 0.0F, 0.0F);
/* 129 */     this.tail = new ModelRenderer(this, 68, 70);
/* 130 */     this.tail.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 9);
/* 131 */     this.tail.setRotationPoint(0.0F, 7.0F, 15.0F);
/* 132 */     this.tail.setTextureSize(128, 128);
/* 133 */     this.tail.mirror = true;
/* 134 */     setRotation(this.tail, 0.2792527F, 0.0F, 0.0F);
/* 135 */     this.bump1 = new ModelRenderer(this, 57, 17);
/* 136 */     this.bump1.addBox(14.0F, -20.0F, -8.0F, 2, 2, 2);
/* 137 */     this.bump1.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 138 */     this.bump1.setTextureSize(128, 128);
/* 139 */     this.bump1.mirror = true;
/* 140 */     setRotation(this.bump1, -0.2617994F, 0.0F, 0.0F);
/* 141 */     this.bump2 = new ModelRenderer(this, 57, 17);
/* 142 */     this.bump2.addBox(14.0F, -15.0F, -8.0F, 2, 2, 2);
/* 143 */     this.bump2.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 144 */     this.bump2.setTextureSize(128, 128);
/* 145 */     this.bump2.mirror = true;
/* 146 */     setRotation(this.bump2, -0.2617994F, 0.0F, 0.0F);
/* 147 */     this.bump3 = new ModelRenderer(this, 57, 17);
/* 148 */     this.bump3.addBox(14.0F, -10.0F, -8.0F, 2, 2, 2);
/* 149 */     this.bump3.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 150 */     this.bump3.setTextureSize(128, 128);
/* 151 */     this.bump3.mirror = true;
/* 152 */     setRotation(this.bump3, -0.2617994F, 0.0F, 0.0F);
/* 153 */     this.bump4 = new ModelRenderer(this, 57, 17);
/* 154 */     this.bump4.addBox(14.0F, -5.0F, -8.0F, 2, 2, 2);
/* 155 */     this.bump4.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 156 */     this.bump4.setTextureSize(128, 128);
/* 157 */     this.bump4.mirror = true;
/* 158 */     setRotation(this.bump4, -0.2617994F, 0.0F, 0.0F);
/* 159 */     this.bump5 = new ModelRenderer(this, 57, 17);
/* 160 */     this.bump5.addBox(14.0F, 0.0F, -8.0F, 2, 2, 2);
/* 161 */     this.bump5.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 162 */     this.bump5.setTextureSize(128, 128);
/* 163 */     this.bump5.mirror = true;
/* 164 */     setRotation(this.bump5, -0.2617994F, 0.0F, 0.0F);
/* 165 */     this.bump6 = new ModelRenderer(this, 57, 17);
/* 166 */     this.bump6.addBox(-16.0F, -20.0F, -8.0F, 2, 2, 2);
/* 167 */     this.bump6.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 168 */     this.bump6.setTextureSize(128, 128);
/* 169 */     this.bump6.mirror = true;
/* 170 */     setRotation(this.bump6, -0.2617994F, 0.0F, 0.0F);
/* 171 */     this.bump7 = new ModelRenderer(this, 57, 17);
/* 172 */     this.bump7.addBox(-16.0F, -15.0F, -8.0F, 2, 2, 2);
/* 173 */     this.bump7.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 174 */     this.bump7.setTextureSize(128, 128);
/* 175 */     this.bump7.mirror = true;
/* 176 */     setRotation(this.bump7, -0.2617994F, 0.0F, 0.0F);
/* 177 */     this.bump8 = new ModelRenderer(this, 57, 17);
/* 178 */     this.bump8.addBox(-16.0F, -10.0F, -8.0F, 2, 2, 2);
/* 179 */     this.bump8.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 180 */     this.bump8.setTextureSize(128, 128);
/* 181 */     this.bump8.mirror = true;
/* 182 */     setRotation(this.bump8, -0.2617994F, 0.0F, 0.0F);
/* 183 */     this.bump9 = new ModelRenderer(this, 57, 17);
/* 184 */     this.bump9.addBox(-16.0F, -5.0F, -8.0F, 2, 2, 2);
/* 185 */     this.bump9.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 186 */     this.bump9.setTextureSize(128, 128);
/* 187 */     this.bump9.mirror = true;
/* 188 */     setRotation(this.bump9, -0.2617994F, 0.0F, 0.0F);
/* 189 */     this.bump10 = new ModelRenderer(this, 57, 17);
/* 190 */     this.bump10.addBox(-16.0F, 0.0F, -8.0F, 2, 2, 2);
/* 191 */     this.bump10.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 192 */     this.bump10.setTextureSize(128, 128);
/* 193 */     this.bump10.mirror = true;
/* 194 */     setRotation(this.bump10, -0.2617994F, 0.0F, 0.0F);
/* 195 */     this.bump11 = new ModelRenderer(this, 57, 17);
/* 196 */     this.bump11.addBox(12.0F, -22.0F, -8.0F, 2, 2, 2);
/* 197 */     this.bump11.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 198 */     this.bump11.setTextureSize(128, 128);
/* 199 */     this.bump11.mirror = true;
/* 200 */     setRotation(this.bump11, -0.2617994F, 0.0F, 0.0F);
/* 201 */     this.bump12 = new ModelRenderer(this, 57, 17);
/* 202 */     this.bump12.addBox(7.0F, -22.0F, -8.0F, 2, 2, 2);
/* 203 */     this.bump12.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 204 */     this.bump12.setTextureSize(128, 128);
/* 205 */     this.bump12.mirror = true;
/* 206 */     setRotation(this.bump12, -0.2617994F, 0.0F, 0.0F);
/* 207 */     this.bump13 = new ModelRenderer(this, 57, 17);
/* 208 */     this.bump13.addBox(2.0F, -22.0F, -8.0F, 2, 2, 2);
/* 209 */     this.bump13.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 210 */     this.bump13.setTextureSize(128, 128);
/* 211 */     this.bump13.mirror = true;
/* 212 */     setRotation(this.bump13, -0.2617994F, 0.0F, 0.0F);
/* 213 */     this.bump14 = new ModelRenderer(this, 57, 17);
/* 214 */     this.bump14.addBox(-4.0F, -22.0F, -8.0F, 2, 2, 2);
/* 215 */     this.bump14.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 216 */     this.bump14.setTextureSize(128, 128);
/* 217 */     this.bump14.mirror = true;
/* 218 */     setRotation(this.bump14, -0.2617994F, 0.0F, 0.0F);
/* 219 */     this.bump15 = new ModelRenderer(this, 57, 17);
/* 220 */     this.bump15.addBox(-9.0F, -22.0F, -8.0F, 2, 2, 2);
/* 221 */     this.bump15.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 222 */     this.bump15.setTextureSize(128, 128);
/* 223 */     this.bump15.mirror = true;
/* 224 */     setRotation(this.bump15, -0.2617994F, 0.0F, 0.0F);
/* 225 */     this.bump16 = new ModelRenderer(this, 57, 17);
/* 226 */     this.bump16.addBox(-14.0F, -22.0F, -8.0F, 2, 2, 2);
/* 227 */     this.bump16.setRotationPoint(0.0F, 11.0F, -7.0F);
/* 228 */     this.bump16.setTextureSize(128, 128);
/* 229 */     this.bump16.mirror = true;
/* 230 */     setRotation(this.bump16, -0.2617994F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 235 */     Pointysaurus e = (Pointysaurus)entity;
/* 236 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 237 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 238 */     float newangle = 0.0F;
/*     */     
/* 240 */     if (f1 > 0.1D) {
/* 241 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 243 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 246 */     this.lfleg.rotateAngleX = newangle;
/* 247 */     this.rrleg.rotateAngleX = newangle;
/* 248 */     this.rfleg.rotateAngleX = -newangle;
/* 249 */     this.lrleg.rotateAngleX = -newangle;
/*     */     
/* 251 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 252 */     this.nose.rotateAngleY = this.head.rotateAngleY;
/* 253 */     this.chorn.rotateAngleY = this.head.rotateAngleY;
/* 254 */     this.head.rotateAngleY -= 0.14F;
/* 255 */     this.head.rotateAngleY += 0.14F;
/* 256 */     this.guard.rotateAngleY = this.head.rotateAngleY;
/* 257 */     this.bump1.rotateAngleY = this.head.rotateAngleY;
/* 258 */     this.bump2.rotateAngleY = this.head.rotateAngleY;
/* 259 */     this.bump3.rotateAngleY = this.head.rotateAngleY;
/* 260 */     this.bump4.rotateAngleY = this.head.rotateAngleY;
/* 261 */     this.bump5.rotateAngleY = this.head.rotateAngleY;
/* 262 */     this.bump6.rotateAngleY = this.head.rotateAngleY;
/* 263 */     this.bump7.rotateAngleY = this.head.rotateAngleY;
/* 264 */     this.bump8.rotateAngleY = this.head.rotateAngleY;
/* 265 */     this.bump9.rotateAngleY = this.head.rotateAngleY;
/* 266 */     this.bump10.rotateAngleY = this.head.rotateAngleY;
/* 267 */     this.bump11.rotateAngleY = this.head.rotateAngleY;
/* 268 */     this.bump12.rotateAngleY = this.head.rotateAngleY;
/* 269 */     this.bump13.rotateAngleY = this.head.rotateAngleY;
/* 270 */     this.bump14.rotateAngleY = this.head.rotateAngleY;
/* 271 */     this.bump15.rotateAngleY = this.head.rotateAngleY;
/* 272 */     this.bump16.rotateAngleY = this.head.rotateAngleY;
/*     */     
/* 274 */     this.head.rotateAngleX = (float)Math.toRadians(f4) * 0.45F;
/* 275 */     this.nose.rotateAngleX = this.head.rotateAngleX;
/* 276 */     this.chorn.rotateAngleX = this.head.rotateAngleX;
/* 277 */     this.head.rotateAngleX -= 0.16F;
/* 278 */     this.head.rotateAngleX -= 0.16F;
/* 279 */     this.head.rotateAngleX -= 0.262F;
/* 280 */     this.bump1.rotateAngleX = this.guard.rotateAngleX;
/* 281 */     this.bump2.rotateAngleX = this.guard.rotateAngleX;
/* 282 */     this.bump3.rotateAngleX = this.guard.rotateAngleX;
/* 283 */     this.bump4.rotateAngleX = this.guard.rotateAngleX;
/* 284 */     this.bump5.rotateAngleX = this.guard.rotateAngleX;
/* 285 */     this.bump6.rotateAngleX = this.guard.rotateAngleX;
/* 286 */     this.bump7.rotateAngleX = this.guard.rotateAngleX;
/* 287 */     this.bump8.rotateAngleX = this.guard.rotateAngleX;
/* 288 */     this.bump9.rotateAngleX = this.guard.rotateAngleX;
/* 289 */     this.bump10.rotateAngleX = this.guard.rotateAngleX;
/* 290 */     this.bump11.rotateAngleX = this.guard.rotateAngleX;
/* 291 */     this.bump12.rotateAngleX = this.guard.rotateAngleX;
/* 292 */     this.bump13.rotateAngleX = this.guard.rotateAngleX;
/* 293 */     this.bump14.rotateAngleX = this.guard.rotateAngleX;
/* 294 */     this.bump15.rotateAngleX = this.guard.rotateAngleX;
/* 295 */     this.bump16.rotateAngleX = this.guard.rotateAngleX;
/*     */     
/* 297 */     if (e.getAttacking() != 0) {
/* 298 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F;
/*     */     } else {
/* 300 */       newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.05F;
/*     */     } 
/* 302 */     this.tail.rotateAngleY = newangle;
/*     */     
/* 304 */     newangle = MathHelper.cos(f2 * 0.02F * this.wingspeed) * 3.1415927F * 0.15F;
/* 305 */     this.tail.rotateAngleX = newangle + 0.28F;
/*     */ 
/*     */     
/* 308 */     this.lfleg.render(f5);
/* 309 */     this.rfleg.render(f5);
/* 310 */     this.lrleg.render(f5);
/* 311 */     this.rrleg.render(f5);
/* 312 */     this.body1.render(f5);
/* 313 */     this.head.render(f5);
/* 314 */     this.body2.render(f5);
/* 315 */     this.body3.render(f5);
/* 316 */     this.guard.render(f5);
/* 317 */     this.nose.render(f5);
/* 318 */     this.lhorn.render(f5);
/* 319 */     this.rhorn.render(f5);
/* 320 */     this.chorn.render(f5);
/* 321 */     this.tail.render(f5);
/* 322 */     this.bump1.render(f5);
/* 323 */     this.bump2.render(f5);
/* 324 */     this.bump3.render(f5);
/* 325 */     this.bump4.render(f5);
/* 326 */     this.bump5.render(f5);
/* 327 */     this.bump6.render(f5);
/* 328 */     this.bump7.render(f5);
/* 329 */     this.bump8.render(f5);
/* 330 */     this.bump9.render(f5);
/* 331 */     this.bump10.render(f5);
/* 332 */     this.bump11.render(f5);
/* 333 */     this.bump12.render(f5);
/* 334 */     this.bump13.render(f5);
/* 335 */     this.bump14.render(f5);
/* 336 */     this.bump15.render(f5);
/* 337 */     this.bump16.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 342 */     model.rotateAngleX = x;
/* 343 */     model.rotateAngleY = y;
/* 344 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 348 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\model\ModelPointysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */