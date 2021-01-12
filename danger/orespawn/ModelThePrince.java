/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelThePrince
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer neckbase;
/*     */   ModelRenderer head;
/*     */   ModelRenderer Rleg1;
/*     */   ModelRenderer Lleg1;
/*     */   ModelRenderer snout;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer Lwing;
/*     */   ModelRenderer Rwing;
/*     */   ModelRenderer Tail5;
/*     */   ModelRenderer Tail6;
/*     */   ModelRenderer Lneck1;
/*     */   ModelRenderer Lneck;
/*     */   ModelRenderer Lhead;
/*     */   ModelRenderer Lsnout;
/*     */   ModelRenderer Rneck1;
/*     */   ModelRenderer Rneck;
/*     */   ModelRenderer Rhead;
/*     */   ModelRenderer Rsnout;
/*     */   ModelRenderer headfin;
/*     */   ModelRenderer Lheadfin;
/*     */   ModelRenderer Rheadfin;
/*     */   ModelRenderer Backfin;
/*     */   ModelRenderer Rwing2;
/*     */   ModelRenderer Rwing3;
/*     */   ModelRenderer Lwing2;
/*     */   ModelRenderer Lwing3;
/*     */   ModelRenderer Ljaw;
/*     */   ModelRenderer jaw;
/*     */   ModelRenderer Rjaw;
/*     */   
/*     */   public ModelThePrince(float f1) {
/*  52 */     this.wingspeed = f1;
/*     */     
/*  54 */     this.textureWidth = 128;
/*  55 */     this.textureHeight = 128;
/*     */     
/*  57 */     this.body = new ModelRenderer(this, 59, 34);
/*  58 */     this.body.addBox(-7.0F, -3.0F, -5.0F, 13, 8, 10);
/*  59 */     this.body.setRotationPoint(0.5F, 15.0F, 1.0F);
/*  60 */     this.body.setTextureSize(128, 128);
/*  61 */     this.body.mirror = true;
/*  62 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  63 */     this.neck1 = new ModelRenderer(this, 20, 45);
/*  64 */     this.neck1.addBox(-1.5F, -2.0F, -1.0F, 3, 4, 4);
/*  65 */     this.neck1.setRotationPoint(0.0F, 16.0F, -5.0F);
/*  66 */     this.neck1.setTextureSize(128, 128);
/*  67 */     this.neck1.mirror = true;
/*  68 */     setRotation(this.neck1, 0.715585F, 0.0F, 0.0F);
/*  69 */     this.neck = new ModelRenderer(this, 20, 31);
/*  70 */     this.neck.addBox(-1.5F, -8.0F, -1.0F, 3, 8, 3);
/*  71 */     this.neck.setRotationPoint(0.0F, 15.0F, -6.0F);
/*  72 */     this.neck.setTextureSize(128, 128);
/*  73 */     this.neck.mirror = true;
/*  74 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/*  75 */     this.neckbase = new ModelRenderer(this, 0, 76);
/*  76 */     this.neckbase.addBox(-4.5F, -4.0F, 0.0F, 9, 6, 3);
/*  77 */     this.neckbase.setRotationPoint(0.0F, 17.0F, 5.0F);
/*  78 */     this.neckbase.setTextureSize(128, 128);
/*  79 */     this.neckbase.mirror = true;
/*  80 */     setRotation(this.neckbase, 0.0F, 0.0F, 0.0F);
/*  81 */     this.head = new ModelRenderer(this, 20, 20);
/*  82 */     this.head.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 5);
/*  83 */     this.head.setRotationPoint(0.0F, 8.0F, -6.0F);
/*  84 */     this.head.setTextureSize(128, 128);
/*  85 */     this.head.mirror = true;
/*  86 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  87 */     this.Rleg1 = new ModelRenderer(this, 0, 58);
/*  88 */     this.Rleg1.addBox(-1.5F, 0.0F, -2.0F, 3, 8, 4);
/*  89 */     this.Rleg1.setRotationPoint(6.0F, 16.0F, 1.0F);
/*  90 */     this.Rleg1.setTextureSize(128, 128);
/*  91 */     this.Rleg1.mirror = true;
/*  92 */     setRotation(this.Rleg1, 0.0F, 0.0F, 0.0F);
/*  93 */     this.Lleg1 = new ModelRenderer(this, 15, 58);
/*  94 */     this.Lleg1.addBox(-1.5F, 0.0F, -2.0F, 3, 8, 4);
/*  95 */     this.Lleg1.setRotationPoint(-6.0F, 16.0F, 1.0F);
/*  96 */     this.Lleg1.setTextureSize(128, 128);
/*  97 */     this.Lleg1.mirror = true;
/*  98 */     setRotation(this.Lleg1, 0.0F, 0.0F, 0.0F);
/*  99 */     this.snout = new ModelRenderer(this, 20, 11);
/* 100 */     this.snout.addBox(-1.5F, -2.0F, -8.5F, 3, 3, 5);
/* 101 */     this.snout.setRotationPoint(0.0F, 8.0F, -6.0F);
/* 102 */     this.snout.setTextureSize(128, 128);
/* 103 */     this.snout.mirror = true;
/* 104 */     setRotation(this.snout, 0.0F, 0.0F, 0.0F);
/* 105 */     this.tail1 = new ModelRenderer(this, 59, 55);
/* 106 */     this.tail1.addBox(-6.0F, -3.0F, -3.0F, 12, 5, 3);
/* 107 */     this.tail1.setRotationPoint(0.0F, 16.5F, -2.0F);
/* 108 */     this.tail1.setTextureSize(128, 128);
/* 109 */     this.tail1.mirror = true;
/* 110 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/* 111 */     this.tail2 = new ModelRenderer(this, 0, 86);
/* 112 */     this.tail2.addBox(-3.0F, -2.5F, 0.0F, 6, 4, 7);
/* 113 */     this.tail2.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 114 */     this.tail2.setTextureSize(128, 128);
/* 115 */     this.tail2.mirror = true;
/* 116 */     setRotation(this.tail2, -0.3839724F, 0.0F, 0.0F);
/* 117 */     this.tail3 = new ModelRenderer(this, 0, 98);
/* 118 */     this.tail3.addBox(-2.0F, -2.0F, 0.0F, 4, 3, 6);
/* 119 */     this.tail3.setRotationPoint(0.0F, 18.2F, 13.0F);
/* 120 */     this.tail3.setTextureSize(128, 128);
/* 121 */     this.tail3.mirror = true;
/* 122 */     setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
/* 123 */     this.tail4 = new ModelRenderer(this, 0, 108);
/* 124 */     this.tail4.addBox(-1.5F, -1.5F, 0.0F, 3, 2, 5);
/* 125 */     this.tail4.setRotationPoint(0.0F, 19.5F, 18.0F);
/* 126 */     this.tail4.setTextureSize(128, 128);
/* 127 */     this.tail4.mirror = true;
/* 128 */     setRotation(this.tail4, -0.0698132F, 0.0F, 0.0F);
/* 129 */     this.Lwing = new ModelRenderer(this, 59, 0);
/* 130 */     this.Lwing.addBox(-22.0F, 0.0F, -3.0F, 22, 0, 10);
/* 131 */     this.Lwing.setRotationPoint(-6.0F, 12.6F, 0.0F);
/* 132 */     this.Lwing.setTextureSize(128, 128);
/* 133 */     this.Lwing.mirror = true;
/* 134 */     setRotation(this.Lwing, 0.0F, 0.0F, 0.4014257F);
/* 135 */     this.Rwing = new ModelRenderer(this, 59, 66);
/* 136 */     this.Rwing.addBox(0.0F, 0.0F, -3.0F, 22, 0, 10);
/* 137 */     this.Rwing.setRotationPoint(6.0F, 12.6F, 0.0F);
/* 138 */     this.Rwing.setTextureSize(128, 128);
/* 139 */     this.Rwing.mirror = true;
/* 140 */     setRotation(this.Rwing, 0.0F, 0.0F, -0.4014257F);
/* 141 */     this.Tail5 = new ModelRenderer(this, 0, 116);
/* 142 */     this.Tail5.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 4);
/* 143 */     this.Tail5.setRotationPoint(0.0F, 18.0F, 22.0F);
/* 144 */     this.Tail5.setTextureSize(128, 128);
/* 145 */     this.Tail5.mirror = true;
/* 146 */     setRotation(this.Tail5, 0.0F, 0.0F, 0.0F);
/* 147 */     this.Tail6 = new ModelRenderer(this, 0, 123);
/* 148 */     this.Tail6.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2);
/* 149 */     this.Tail6.setRotationPoint(0.0F, 18.0F, 26.0F);
/* 150 */     this.Tail6.setTextureSize(128, 128);
/* 151 */     this.Tail6.mirror = true;
/* 152 */     setRotation(this.Tail6, 0.0F, 0.0F, 0.0F);
/* 153 */     this.Lneck1 = new ModelRenderer(this, 0, 45);
/* 154 */     this.Lneck1.addBox(-1.5F, -2.0F, -1.0F, 3, 4, 4);
/* 155 */     this.Lneck1.setRotationPoint(4.5F, 16.0F, -5.0F);
/* 156 */     this.Lneck1.setTextureSize(128, 128);
/* 157 */     this.Lneck1.mirror = true;
/* 158 */     setRotation(this.Lneck1, 0.715585F, 0.0F, 0.0F);
/* 159 */     this.Lneck = new ModelRenderer(this, 0, 30);
/* 160 */     this.Lneck.addBox(-1.5F, -8.0F, -1.0F, 3, 8, 3);
/* 161 */     this.Lneck.setRotationPoint(4.5F, 15.0F, -6.0F);
/* 162 */     this.Lneck.setTextureSize(128, 128);
/* 163 */     this.Lneck.mirror = true;
/* 164 */     setRotation(this.Lneck, 0.0F, 0.0F, 0.0F);
/* 165 */     this.Lhead = new ModelRenderer(this, 0, 20);
/* 166 */     this.Lhead.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 5);
/* 167 */     this.Lhead.setRotationPoint(4.5F, 8.0F, -6.0F);
/* 168 */     this.Lhead.setTextureSize(128, 128);
/* 169 */     this.Lhead.mirror = true;
/* 170 */     setRotation(this.Lhead, -0.0174533F, 0.0F, 0.0F);
/* 171 */     this.Lsnout = new ModelRenderer(this, 0, 11);
/* 172 */     this.Lsnout.addBox(-1.5F, -2.0F, -8.5F, 3, 3, 5);
/* 173 */     this.Lsnout.setRotationPoint(4.5F, 8.0F, -6.0F);
/* 174 */     this.Lsnout.setTextureSize(128, 128);
/* 175 */     this.Lsnout.mirror = true;
/* 176 */     setRotation(this.Lsnout, 0.0F, 0.0F, 0.0F);
/* 177 */     this.Rneck1 = new ModelRenderer(this, 40, 45);
/* 178 */     this.Rneck1.addBox(-1.5F, -2.0F, -1.0F, 3, 4, 4);
/* 179 */     this.Rneck1.setRotationPoint(-4.5F, 16.0F, -5.0F);
/* 180 */     this.Rneck1.setTextureSize(128, 128);
/* 181 */     this.Rneck1.mirror = true;
/* 182 */     setRotation(this.Rneck1, 0.715585F, 0.0F, 0.0F);
/* 183 */     this.Rneck = new ModelRenderer(this, 40, 31);
/* 184 */     this.Rneck.addBox(-1.5F, -8.0F, -1.0F, 3, 8, 3);
/* 185 */     this.Rneck.setRotationPoint(-4.5F, 15.0F, -6.0F);
/* 186 */     this.Rneck.setTextureSize(128, 128);
/* 187 */     this.Rneck.mirror = true;
/* 188 */     setRotation(this.Rneck, 0.0F, 0.0F, 0.0F);
/* 189 */     this.Rhead = new ModelRenderer(this, 40, 20);
/* 190 */     this.Rhead.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 5);
/* 191 */     this.Rhead.setRotationPoint(-4.5F, 8.0F, -6.0F);
/* 192 */     this.Rhead.setTextureSize(128, 128);
/* 193 */     this.Rhead.mirror = true;
/* 194 */     setRotation(this.Rhead, 0.0F, 0.0F, 0.0F);
/* 195 */     this.Rsnout = new ModelRenderer(this, 40, 11);
/* 196 */     this.Rsnout.addBox(-1.5F, -2.0F, -8.5F, 3, 3, 5);
/* 197 */     this.Rsnout.setRotationPoint(-4.5F, 8.0F, -6.0F);
/* 198 */     this.Rsnout.setTextureSize(128, 128);
/* 199 */     this.Rsnout.mirror = true;
/* 200 */     setRotation(this.Rsnout, 0.0F, 0.0F, 0.0F);
/* 201 */     this.headfin = new ModelRenderer(this, 20, 0);
/* 202 */     this.headfin.addBox(-0.5F, -3.0F, 1.0F, 1, 4, 3);
/* 203 */     this.headfin.setRotationPoint(0.0F, 8.0F, -6.0F);
/* 204 */     this.headfin.setTextureSize(128, 128);
/* 205 */     this.headfin.mirror = true;
/* 206 */     setRotation(this.headfin, -0.122173F, 0.0F, 0.0F);
/* 207 */     this.Lheadfin = new ModelRenderer(this, 0, 0);
/* 208 */     this.Lheadfin.addBox(-0.5F, -3.0F, 1.0F, 1, 4, 3);
/* 209 */     this.Lheadfin.setRotationPoint(4.5F, 8.0F, -6.0F);
/* 210 */     this.Lheadfin.setTextureSize(128, 128);
/* 211 */     this.Lheadfin.mirror = true;
/* 212 */     setRotation(this.Lheadfin, -0.122173F, 0.0F, 0.0F);
/* 213 */     this.Rheadfin = new ModelRenderer(this, 40, 0);
/* 214 */     this.Rheadfin.addBox(-0.5F, -3.0F, 1.0F, 1, 4, 3);
/* 215 */     this.Rheadfin.setRotationPoint(-4.5F, 8.0F, -6.0F);
/* 216 */     this.Rheadfin.setTextureSize(128, 128);
/* 217 */     this.Rheadfin.mirror = true;
/* 218 */     setRotation(this.Rheadfin, -0.122173F, 0.0F, 0.0F);
/* 219 */     this.Backfin = new ModelRenderer(this, 35, 57);
/* 220 */     this.Backfin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 5);
/* 221 */     this.Backfin.setRotationPoint(0.0F, 12.0F, -1.0F);
/* 222 */     this.Backfin.setTextureSize(128, 128);
/* 223 */     this.Backfin.mirror = true;
/* 224 */     setRotation(this.Backfin, 0.5061455F, 0.0F, 0.0F);
/* 225 */     this.Rwing2 = new ModelRenderer(this, 59, 77);
/* 226 */     this.Rwing2.addBox(0.0F, 0.0F, -3.0F, 12, 0, 10);
/* 227 */     this.Rwing2.setRotationPoint(6.0F, 12.6F, 0.0F);
/* 228 */     this.Rwing2.setTextureSize(128, 128);
/* 229 */     this.Rwing2.mirror = true;
/* 230 */     setRotation(this.Rwing2, 0.0F, 0.0F, -0.6981317F);
/* 231 */     this.Rwing3 = new ModelRenderer(this, 59, 88);
/* 232 */     this.Rwing3.addBox(0.0F, 0.0F, -3.0F, 10, 0, 10);
/* 233 */     this.Rwing3.setRotationPoint(6.0F, 12.6F, 0.0F);
/* 234 */     this.Rwing3.setTextureSize(128, 128);
/* 235 */     this.Rwing3.mirror = true;
/* 236 */     setRotation(this.Rwing3, 0.0F, 0.0F, -0.0698132F);
/* 237 */     this.Lwing2 = new ModelRenderer(this, 59, 11);
/* 238 */     this.Lwing2.addBox(-12.0F, 0.0F, -3.0F, 12, 0, 10);
/* 239 */     this.Lwing2.setRotationPoint(-6.0F, 12.6F, 0.0F);
/* 240 */     this.Lwing2.setTextureSize(128, 128);
/* 241 */     this.Lwing2.mirror = true;
/* 242 */     setRotation(this.Lwing2, 0.0F, 0.0F, 0.6981317F);
/* 243 */     this.Lwing3 = new ModelRenderer(this, 59, 22);
/* 244 */     this.Lwing3.addBox(-10.0F, 0.0F, -3.0F, 10, 0, 10);
/* 245 */     this.Lwing3.setRotationPoint(-6.0F, 12.6F, 0.0F);
/* 246 */     this.Lwing3.setTextureSize(128, 128);
/* 247 */     this.Lwing3.mirror = true;
/* 248 */     setRotation(this.Lwing3, 0.0F, 0.0F, 0.0698132F);
/* 249 */     this.Ljaw = new ModelRenderer(this, 30, 70);
/* 250 */     this.Ljaw.addBox(-1.5F, 1.0F, -5.0F, 3, 1, 5);
/* 251 */     this.Ljaw.setRotationPoint(4.5F, 8.0F, -7.0F);
/* 252 */     this.Ljaw.setTextureSize(128, 128);
/* 253 */     this.Ljaw.mirror = true;
/* 254 */     setRotation(this.Ljaw, 0.2443461F, 0.0F, 0.0F);
/* 255 */     this.jaw = new ModelRenderer(this, 30, 80);
/* 256 */     this.jaw.addBox(-1.5F, 1.0F, -5.0F, 3, 1, 5);
/* 257 */     this.jaw.setRotationPoint(0.0F, 8.0F, -7.0F);
/* 258 */     this.jaw.setTextureSize(128, 128);
/* 259 */     this.jaw.mirror = true;
/* 260 */     setRotation(this.jaw, 0.2443461F, 0.0F, 0.0F);
/* 261 */     this.Rjaw = new ModelRenderer(this, 30, 90);
/* 262 */     this.Rjaw.addBox(-1.5F, 1.0F, -5.0F, 3, 1, 5);
/* 263 */     this.Rjaw.setRotationPoint(-4.5F, 8.0F, -7.0F);
/* 264 */     this.Rjaw.setTextureSize(128, 128);
/* 265 */     this.Rjaw.mirror = true;
/* 266 */     setRotation(this.Rjaw, 0.2443461F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 274 */     ThePrince c = (ThePrince)entity;
/* 275 */     float hf = 0.0F;
/* 276 */     float newangle = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 280 */     int current_activity = c.getActivity();
/*     */     
/* 282 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 283 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */     
/* 287 */     if (f1 > 0.1D || c.getAttacking() != 0) {
/* 288 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/*     */     } else {
/* 290 */       newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.04F;
/*     */     } 
/*     */     
/* 293 */     this.Rwing.rotateAngleZ = newangle - 0.4F;
/* 294 */     this.Rwing2.rotateAngleZ = newangle - 0.6F;
/* 295 */     this.Rwing3.rotateAngleZ = newangle - 0.2F;
/* 296 */     this.Lwing.rotateAngleZ = -newangle + 0.4F;
/* 297 */     this.Lwing2.rotateAngleZ = -newangle + 0.6F;
/* 298 */     this.Lwing3.rotateAngleZ = -newangle + 0.2F;
/*     */ 
/*     */ 
/*     */     
/* 302 */     if (f1 > 0.1D) {
/* 303 */       newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 305 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 308 */     if (current_activity != 2 || c.getAttacking() != 0) {
/* 309 */       this.Rleg1.rotateAngleX = newangle;
/* 310 */       this.Lleg1.rotateAngleX = -newangle;
/*     */     } else {
/*     */       
/* 313 */       newangle = -1.0F;
/* 314 */       this.Rleg1.rotateAngleX = newangle;
/* 315 */       this.Lleg1.rotateAngleX = newangle;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 320 */     newangle = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.06F;
/* 321 */     if (c.isSitting() == true) {
/* 322 */       newangle = 0.0F;
/*     */     }
/* 324 */     if (c.getAttacking() != 0) {
/* 325 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.12F;
/*     */     }
/* 327 */     this.tail2.rotateAngleY = newangle;
/*     */     
/* 329 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 6.0F;
/* 330 */     this.tail2.rotationPointX += (float)Math.sin(this.tail2.rotateAngleY) * 6.0F;
/* 331 */     this.tail3.rotateAngleY = newangle * 1.6F;
/*     */     
/* 333 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 5.0F;
/* 334 */     this.tail3.rotationPointX += (float)Math.sin(this.tail3.rotateAngleY) * 5.0F;
/* 335 */     this.tail4.rotateAngleY = newangle * 2.6F;
/*     */     
/* 337 */     this.tail4.rotationPointZ += (float)Math.cos(this.tail4.rotateAngleY) * 4.0F;
/* 338 */     this.tail4.rotationPointX += (float)Math.sin(this.tail4.rotateAngleY) * 4.0F;
/* 339 */     this.Tail5.rotateAngleY = newangle * 3.6F;
/*     */     
/* 341 */     this.Tail5.rotationPointZ += (float)Math.cos(this.Tail5.rotateAngleY) * 4.0F;
/* 342 */     this.Tail5.rotationPointX += (float)Math.sin(this.Tail5.rotateAngleY) * 4.0F;
/* 343 */     this.Tail6.rotateAngleY = newangle * 4.6F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 348 */     float h3 = f3 * 2.0F / 3.0F, h2 = h3, h1 = h2;
/* 349 */     float d3 = f4 * 2.0F / 3.0F, d2 = d3, d1 = d2;
/* 350 */     if (h1 < 0.0F) {
/* 351 */       h2 = h3 = h1 / 2.0F;
/* 352 */       d2 = d3 = d1 / 2.0F;
/*     */     } else {
/* 354 */       h2 = h1 = h3 / 2.0F;
/* 355 */       d2 = d1 = d3 / 2.0F;
/*     */     } 
/* 357 */     this.head.rotateAngleY = (float)Math.toRadians(h2);
/* 358 */     this.snout.rotateAngleY = (float)Math.toRadians(h2);
/* 359 */     this.headfin.rotateAngleY = (float)Math.toRadians(h2);
/* 360 */     this.jaw.rotateAngleY = (float)Math.toRadians(h2);
/* 361 */     this.snout.rotationPointZ -= (float)Math.cos(this.snout.rotateAngleY);
/* 362 */     this.snout.rotationPointX -= (float)Math.sin(this.snout.rotateAngleY);
/* 363 */     this.neck.rotateAngleY = (float)Math.toRadians(h2) / 2.0F;
/*     */     
/* 365 */     this.Lhead.rotateAngleY = (float)Math.toRadians(h1);
/* 366 */     this.Lsnout.rotateAngleY = (float)Math.toRadians(h1);
/* 367 */     this.Lheadfin.rotateAngleY = (float)Math.toRadians(h1);
/* 368 */     this.Ljaw.rotateAngleY = (float)Math.toRadians(h1);
/* 369 */     this.Lsnout.rotationPointZ -= (float)Math.cos(this.Lsnout.rotateAngleY);
/* 370 */     this.Lsnout.rotationPointX -= (float)Math.sin(this.Lsnout.rotateAngleY);
/* 371 */     this.Lneck.rotateAngleY = (float)Math.toRadians(h1) / 2.0F;
/*     */     
/* 373 */     this.Rhead.rotateAngleY = (float)Math.toRadians(h3);
/* 374 */     this.Rsnout.rotateAngleY = (float)Math.toRadians(h3);
/* 375 */     this.Rheadfin.rotateAngleY = (float)Math.toRadians(h3);
/* 376 */     this.Rjaw.rotateAngleY = (float)Math.toRadians(h3);
/* 377 */     this.Rsnout.rotationPointZ -= (float)Math.cos(this.Rsnout.rotateAngleY);
/* 378 */     this.Rsnout.rotationPointX -= (float)Math.sin(this.Rsnout.rotateAngleY);
/* 379 */     this.Rneck.rotateAngleY = (float)Math.toRadians(h3) / 2.0F;
/*     */     
/* 381 */     float Rjx = 0.0F, jx = Rjx, Ljx = jx;
/* 382 */     if (c.getAttacking() != 0) {
/* 383 */       newangle = MathHelper.cos(f2 * 1.9F * this.wingspeed) * 3.1415927F * 0.2F;
/* 384 */       Ljx = 0.2F + newangle;
/* 385 */       newangle = MathHelper.cos(f2 * 2.1F * this.wingspeed) * 3.1415927F * 0.2F;
/* 386 */       Rjx = 0.2F + newangle;
/* 387 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.2F;
/* 388 */       jx = 0.2F + newangle;
/*     */     } 
/*     */ 
/*     */     
/* 392 */     this.head.rotateAngleX = (float)Math.toRadians(d2);
/* 393 */     this.snout.rotateAngleX = (float)Math.toRadians(d2);
/* 394 */     this.headfin.rotateAngleX = (float)Math.toRadians(d2);
/* 395 */     this.jaw.rotateAngleX = (float)Math.toRadians(d2) + jx;
/*     */     
/* 397 */     this.Lhead.rotateAngleX = (float)Math.toRadians(d1);
/* 398 */     this.Lsnout.rotateAngleX = (float)Math.toRadians(d1);
/* 399 */     this.Lheadfin.rotateAngleX = (float)Math.toRadians(d1);
/* 400 */     this.Ljaw.rotateAngleX = (float)Math.toRadians(d1) + Ljx;
/*     */     
/* 402 */     this.Rhead.rotateAngleX = (float)Math.toRadians(d3);
/* 403 */     this.Rsnout.rotateAngleX = (float)Math.toRadians(d3);
/* 404 */     this.Rheadfin.rotateAngleX = (float)Math.toRadians(d3);
/* 405 */     this.Rjaw.rotateAngleX = (float)Math.toRadians(d3) + Rjx;
/*     */ 
/*     */     
/* 408 */     d1 = c.getHead1Ext();
/* 409 */     d2 = c.getHead2Ext();
/* 410 */     d3 = c.getHead3Ext();
/*     */     
/* 412 */     this.Lneck.rotateAngleX = (float)Math.toRadians(d1);
/* 413 */     this.neck.rotateAngleX = (float)Math.toRadians(d2);
/* 414 */     this.Rneck.rotateAngleX = (float)Math.toRadians(d3);
/*     */     
/* 416 */     this.Lneck.rotationPointY -= (float)Math.cos(this.Lneck.rotateAngleX) * 7.0F;
/* 417 */     this.Ljaw.rotationPointY = this.Lhead.rotationPointY;
/* 418 */     this.Lneck.rotationPointZ -= (float)Math.sin(this.Lneck.rotateAngleX) * 7.0F;
/* 419 */     this.Ljaw.rotationPointZ = this.Lhead.rotationPointZ;
/* 420 */     this.Lneck.rotationPointX -= (float)Math.sin(this.Lneck.rotateAngleY) * 7.0F * (float)Math.sin(this.Lneck.rotateAngleX);
/* 421 */     this.Ljaw.rotationPointX = this.Lhead.rotationPointX;
/*     */     
/* 423 */     this.Rneck.rotationPointY -= (float)Math.cos(this.Rneck.rotateAngleX) * 7.0F;
/* 424 */     this.Rjaw.rotationPointY = this.Rhead.rotationPointY;
/* 425 */     this.Rneck.rotationPointZ -= (float)Math.sin(this.Rneck.rotateAngleX) * 7.0F;
/* 426 */     this.Rjaw.rotationPointZ = this.Rhead.rotationPointZ;
/* 427 */     this.Rneck.rotationPointX -= (float)Math.sin(this.Rneck.rotateAngleY) * 7.0F * (float)Math.sin(this.Rneck.rotateAngleX);
/* 428 */     this.Rjaw.rotationPointX = this.Rhead.rotationPointX;
/*     */     
/* 430 */     this.neck.rotationPointY -= (float)Math.cos(this.neck.rotateAngleX) * 7.0F;
/* 431 */     this.jaw.rotationPointY = this.head.rotationPointY;
/* 432 */     this.neck.rotationPointZ -= (float)Math.sin(this.neck.rotateAngleX) * 7.0F;
/* 433 */     this.jaw.rotationPointZ = this.head.rotationPointZ;
/* 434 */     this.neck.rotationPointX -= (float)Math.sin(this.neck.rotateAngleY) * 7.0F * (float)Math.sin(this.neck.rotateAngleX);
/* 435 */     this.jaw.rotationPointX = this.head.rotationPointX;
/*     */     
/* 437 */     this.body.render(f5);
/* 438 */     this.neck1.render(f5);
/* 439 */     this.neck.render(f5);
/* 440 */     this.neckbase.render(f5);
/* 441 */     this.head.render(f5);
/* 442 */     this.Rleg1.render(f5);
/* 443 */     this.Lleg1.render(f5);
/* 444 */     this.snout.render(f5);
/* 445 */     this.tail1.render(f5);
/* 446 */     this.tail2.render(f5);
/* 447 */     this.tail3.render(f5);
/* 448 */     this.tail4.render(f5);
/* 449 */     this.Tail5.render(f5);
/* 450 */     this.Tail6.render(f5);
/* 451 */     this.Lneck1.render(f5);
/* 452 */     this.Lneck.render(f5);
/* 453 */     this.Lhead.render(f5);
/* 454 */     this.Lsnout.render(f5);
/* 455 */     this.Rneck1.render(f5);
/* 456 */     this.Rneck.render(f5);
/* 457 */     this.Rhead.render(f5);
/* 458 */     this.Rsnout.render(f5);
/* 459 */     this.headfin.render(f5);
/* 460 */     this.Lheadfin.render(f5);
/* 461 */     this.Rheadfin.render(f5);
/* 462 */     this.Backfin.render(f5);
/* 463 */     this.Ljaw.render(f5);
/* 464 */     this.jaw.render(f5);
/* 465 */     this.Rjaw.render(f5);
/*     */     
/* 467 */     GL11.glPushMatrix();
/* 468 */     GL11.glEnable(2977);
/* 469 */     GL11.glEnable(3042);
/* 470 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 472 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.55F);
/* 473 */     this.Rwing2.render(f5);
/* 474 */     this.Rwing3.render(f5);
/* 475 */     this.Lwing2.render(f5);
/* 476 */     this.Lwing3.render(f5);
/* 477 */     this.Lwing.render(f5);
/* 478 */     this.Rwing.render(f5);
/* 479 */     GL11.glDisable(3042);
/* 480 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 485 */     model.rotateAngleX = x;
/* 486 */     model.rotateAngleY = y;
/* 487 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 492 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelThePrince.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */