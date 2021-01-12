/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelThePrincess
/*     */   extends ModelBase
/*     */ {
/*  13 */   private float wingspeed = 1.0F;
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
/*     */   ModelRenderer Lpower;
/*     */   ModelRenderer Cpower;
/*     */   ModelRenderer Rpower;
/*     */   
/*     */   public ModelThePrincess(float f1) {
/*  55 */     this.wingspeed = f1;
/*     */     
/*  57 */     this.textureWidth = 128;
/*  58 */     this.textureHeight = 128;
/*     */     
/*  60 */     this.body = new ModelRenderer(this, 59, 34);
/*  61 */     this.body.addBox(-7.0F, -3.0F, -3.0F, 13, 8, 8);
/*  62 */     this.body.setRotationPoint(0.5F, 15.0F, 1.0F);
/*  63 */     this.body.setTextureSize(64, 32);
/*  64 */     this.body.mirror = true;
/*  65 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  66 */     this.neck1 = new ModelRenderer(this, 20, 45);
/*  67 */     this.neck1.addBox(-1.5F, -2.0F, -1.0F, 3, 1, 4);
/*  68 */     this.neck1.setRotationPoint(0.0F, 15.0F, -5.0F);
/*  69 */     this.neck1.setTextureSize(64, 32);
/*  70 */     this.neck1.mirror = true;
/*  71 */     setRotation(this.neck1, 0.0F, 0.0F, 0.0F);
/*  72 */     this.neck = new ModelRenderer(this, 20, 31);
/*  73 */     this.neck.addBox(-1.5F, -8.0F, -1.0F, 3, 8, 3);
/*  74 */     this.neck.setRotationPoint(0.0F, 14.0F, -6.0F);
/*  75 */     this.neck.setTextureSize(64, 32);
/*  76 */     this.neck.mirror = true;
/*  77 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/*  78 */     this.neckbase = new ModelRenderer(this, 0, 76);
/*  79 */     this.neckbase.addBox(-4.5F, -4.0F, 0.0F, 9, 6, 3);
/*  80 */     this.neckbase.setRotationPoint(0.0F, 17.0F, 5.0F);
/*  81 */     this.neckbase.setTextureSize(64, 32);
/*  82 */     this.neckbase.mirror = true;
/*  83 */     setRotation(this.neckbase, 0.0F, 0.0F, 0.0F);
/*  84 */     this.head = new ModelRenderer(this, 20, 20);
/*  85 */     this.head.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 5);
/*  86 */     this.head.setRotationPoint(0.0F, 7.0F, -6.0F);
/*  87 */     this.head.setTextureSize(64, 32);
/*  88 */     this.head.mirror = true;
/*  89 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  90 */     this.Rleg1 = new ModelRenderer(this, 0, 58);
/*  91 */     this.Rleg1.addBox(-1.5F, 0.0F, -2.0F, 3, 8, 4);
/*  92 */     this.Rleg1.setRotationPoint(6.0F, 16.0F, 1.0F);
/*  93 */     this.Rleg1.setTextureSize(64, 32);
/*  94 */     this.Rleg1.mirror = true;
/*  95 */     setRotation(this.Rleg1, 0.0F, 0.0F, 0.0F);
/*  96 */     this.Lleg1 = new ModelRenderer(this, 15, 58);
/*  97 */     this.Lleg1.addBox(-1.5F, 0.0F, -2.0F, 3, 8, 4);
/*  98 */     this.Lleg1.setRotationPoint(-6.0F, 16.0F, 1.0F);
/*  99 */     this.Lleg1.setTextureSize(64, 32);
/* 100 */     this.Lleg1.mirror = true;
/* 101 */     setRotation(this.Lleg1, 0.0F, 0.0F, 0.0F);
/* 102 */     this.snout = new ModelRenderer(this, 20, 11);
/* 103 */     this.snout.addBox(-1.5F, -2.0F, -8.5F, 3, 3, 5);
/* 104 */     this.snout.setRotationPoint(0.0F, 7.0F, -6.0F);
/* 105 */     this.snout.setTextureSize(64, 32);
/* 106 */     this.snout.mirror = true;
/* 107 */     setRotation(this.snout, 0.0F, 0.0F, 0.0F);
/* 108 */     this.tail2 = new ModelRenderer(this, 0, 86);
/* 109 */     this.tail2.addBox(-3.0F, -2.5F, 0.0F, 6, 4, 7);
/* 110 */     this.tail2.setRotationPoint(0.0F, 16.0F, 7.0F);
/* 111 */     this.tail2.setTextureSize(64, 32);
/* 112 */     this.tail2.mirror = true;
/* 113 */     setRotation(this.tail2, -0.3839724F, 0.0F, 0.0F);
/* 114 */     this.tail3 = new ModelRenderer(this, 0, 98);
/* 115 */     this.tail3.addBox(-2.0F, -2.0F, 0.0F, 4, 3, 6);
/* 116 */     this.tail3.setRotationPoint(0.0F, 18.2F, 13.0F);
/* 117 */     this.tail3.setTextureSize(64, 32);
/* 118 */     this.tail3.mirror = true;
/* 119 */     setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
/* 120 */     this.tail4 = new ModelRenderer(this, 0, 108);
/* 121 */     this.tail4.addBox(-1.5F, -1.5F, 0.0F, 3, 2, 5);
/* 122 */     this.tail4.setRotationPoint(0.0F, 19.5F, 18.0F);
/* 123 */     this.tail4.setTextureSize(64, 32);
/* 124 */     this.tail4.mirror = true;
/* 125 */     setRotation(this.tail4, -0.0698132F, 0.0F, 0.0F);
/* 126 */     this.Lwing = new ModelRenderer(this, 59, 0);
/* 127 */     this.Lwing.addBox(-22.0F, 0.0F, -3.0F, 22, 0, 10);
/* 128 */     this.Lwing.setRotationPoint(-6.0F, 12.6F, 0.0F);
/* 129 */     this.Lwing.setTextureSize(64, 32);
/* 130 */     this.Lwing.mirror = true;
/* 131 */     setRotation(this.Lwing, 0.0F, 0.0F, 0.4014257F);
/* 132 */     this.Rwing = new ModelRenderer(this, 59, 66);
/* 133 */     this.Rwing.addBox(0.0F, 0.0F, -3.0F, 22, 0, 10);
/* 134 */     this.Rwing.setRotationPoint(6.0F, 12.6F, 0.0F);
/* 135 */     this.Rwing.setTextureSize(64, 32);
/* 136 */     this.Rwing.mirror = true;
/* 137 */     setRotation(this.Rwing, 0.0F, 0.0F, -0.4014257F);
/* 138 */     this.Tail5 = new ModelRenderer(this, 0, 116);
/* 139 */     this.Tail5.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 4);
/* 140 */     this.Tail5.setRotationPoint(0.0F, 18.0F, 22.0F);
/* 141 */     this.Tail5.setTextureSize(64, 32);
/* 142 */     this.Tail5.mirror = true;
/* 143 */     setRotation(this.Tail5, 0.0F, 0.0F, 0.0F);
/* 144 */     this.Tail6 = new ModelRenderer(this, 0, 123);
/* 145 */     this.Tail6.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2);
/* 146 */     this.Tail6.setRotationPoint(0.0F, 18.0F, 26.0F);
/* 147 */     this.Tail6.setTextureSize(64, 32);
/* 148 */     this.Tail6.mirror = true;
/* 149 */     setRotation(this.Tail6, 0.0F, 0.0F, 0.0F);
/* 150 */     this.Lneck1 = new ModelRenderer(this, 0, 45);
/* 151 */     this.Lneck1.addBox(-1.5F, -2.0F, -1.0F, 3, 1, 4);
/* 152 */     this.Lneck1.setRotationPoint(4.5F, 15.0F, -5.0F);
/* 153 */     this.Lneck1.setTextureSize(64, 32);
/* 154 */     this.Lneck1.mirror = true;
/* 155 */     setRotation(this.Lneck1, 0.0F, 0.0F, 0.0F);
/* 156 */     this.Lneck = new ModelRenderer(this, 0, 30);
/* 157 */     this.Lneck.addBox(-1.5F, -8.0F, -1.0F, 3, 8, 3);
/* 158 */     this.Lneck.setRotationPoint(4.5F, 14.0F, -6.0F);
/* 159 */     this.Lneck.setTextureSize(64, 32);
/* 160 */     this.Lneck.mirror = true;
/* 161 */     setRotation(this.Lneck, 0.0F, 0.0F, 0.0F);
/* 162 */     this.Lhead = new ModelRenderer(this, 0, 20);
/* 163 */     this.Lhead.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 5);
/* 164 */     this.Lhead.setRotationPoint(4.5F, 7.0F, -6.0F);
/* 165 */     this.Lhead.setTextureSize(64, 32);
/* 166 */     this.Lhead.mirror = true;
/* 167 */     setRotation(this.Lhead, -0.0174533F, 0.0F, 0.0F);
/* 168 */     this.Lsnout = new ModelRenderer(this, 0, 11);
/* 169 */     this.Lsnout.addBox(-1.5F, -2.0F, -8.5F, 3, 3, 5);
/* 170 */     this.Lsnout.setRotationPoint(4.5F, 7.0F, -6.0F);
/* 171 */     this.Lsnout.setTextureSize(64, 32);
/* 172 */     this.Lsnout.mirror = true;
/* 173 */     setRotation(this.Lsnout, 0.0F, 0.0F, 0.0F);
/* 174 */     this.Rneck1 = new ModelRenderer(this, 40, 45);
/* 175 */     this.Rneck1.addBox(-1.5F, -2.0F, -1.0F, 3, 1, 4);
/* 176 */     this.Rneck1.setRotationPoint(-4.5F, 15.0F, -5.0F);
/* 177 */     this.Rneck1.setTextureSize(64, 32);
/* 178 */     this.Rneck1.mirror = true;
/* 179 */     setRotation(this.Rneck1, 0.0F, 0.0F, 0.0F);
/* 180 */     this.Rneck = new ModelRenderer(this, 40, 31);
/* 181 */     this.Rneck.addBox(-1.5F, -8.0F, -1.0F, 3, 8, 3);
/* 182 */     this.Rneck.setRotationPoint(-4.5F, 14.0F, -6.0F);
/* 183 */     this.Rneck.setTextureSize(64, 32);
/* 184 */     this.Rneck.mirror = true;
/* 185 */     setRotation(this.Rneck, 0.0F, 0.0F, 0.0F);
/* 186 */     this.Rhead = new ModelRenderer(this, 40, 20);
/* 187 */     this.Rhead.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 5);
/* 188 */     this.Rhead.setRotationPoint(-4.5F, 7.0F, -6.0F);
/* 189 */     this.Rhead.setTextureSize(64, 32);
/* 190 */     this.Rhead.mirror = true;
/* 191 */     setRotation(this.Rhead, 0.0F, 0.0F, 0.0F);
/* 192 */     this.Rsnout = new ModelRenderer(this, 40, 11);
/* 193 */     this.Rsnout.addBox(-1.5F, -2.0F, -8.5F, 3, 3, 5);
/* 194 */     this.Rsnout.setRotationPoint(-4.5F, 7.0F, -6.0F);
/* 195 */     this.Rsnout.setTextureSize(64, 32);
/* 196 */     this.Rsnout.mirror = true;
/* 197 */     setRotation(this.Rsnout, 0.0F, 0.0F, 0.0F);
/* 198 */     this.headfin = new ModelRenderer(this, 20, 0);
/* 199 */     this.headfin.addBox(-0.5F, -3.0F, 1.0F, 1, 4, 3);
/* 200 */     this.headfin.setRotationPoint(0.0F, 7.0F, -6.0F);
/* 201 */     this.headfin.setTextureSize(64, 32);
/* 202 */     this.headfin.mirror = true;
/* 203 */     setRotation(this.headfin, -0.122173F, 0.0F, 0.0F);
/* 204 */     this.Lheadfin = new ModelRenderer(this, 0, 0);
/* 205 */     this.Lheadfin.addBox(-0.5F, -3.0F, 1.0F, 1, 4, 3);
/* 206 */     this.Lheadfin.setRotationPoint(4.5F, 7.0F, -6.0F);
/* 207 */     this.Lheadfin.setTextureSize(64, 32);
/* 208 */     this.Lheadfin.mirror = true;
/* 209 */     setRotation(this.Lheadfin, -0.122173F, 0.0F, 0.0F);
/* 210 */     this.Rheadfin = new ModelRenderer(this, 40, 0);
/* 211 */     this.Rheadfin.addBox(-0.5F, -3.0F, 1.0F, 1, 4, 3);
/* 212 */     this.Rheadfin.setRotationPoint(-4.5F, 7.0F, -6.0F);
/* 213 */     this.Rheadfin.setTextureSize(64, 32);
/* 214 */     this.Rheadfin.mirror = true;
/* 215 */     setRotation(this.Rheadfin, -0.122173F, 0.0F, 0.0F);
/* 216 */     this.Backfin = new ModelRenderer(this, 35, 57);
/* 217 */     this.Backfin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 5);
/* 218 */     this.Backfin.setRotationPoint(0.0F, 12.0F, -1.0F);
/* 219 */     this.Backfin.setTextureSize(64, 32);
/* 220 */     this.Backfin.mirror = true;
/* 221 */     setRotation(this.Backfin, 0.5061455F, 0.0F, 0.0F);
/* 222 */     this.Rwing2 = new ModelRenderer(this, 59, 77);
/* 223 */     this.Rwing2.addBox(0.0F, 0.0F, -3.0F, 12, 0, 10);
/* 224 */     this.Rwing2.setRotationPoint(6.0F, 12.6F, 0.0F);
/* 225 */     this.Rwing2.setTextureSize(64, 32);
/* 226 */     this.Rwing2.mirror = true;
/* 227 */     setRotation(this.Rwing2, 0.0F, 0.0F, -0.6981317F);
/* 228 */     this.Rwing3 = new ModelRenderer(this, 59, 88);
/* 229 */     this.Rwing3.addBox(0.0F, 0.0F, -3.0F, 10, 0, 10);
/* 230 */     this.Rwing3.setRotationPoint(6.0F, 12.6F, 0.0F);
/* 231 */     this.Rwing3.setTextureSize(64, 32);
/* 232 */     this.Rwing3.mirror = true;
/* 233 */     setRotation(this.Rwing3, 0.0F, 0.0F, -0.0698132F);
/* 234 */     this.Lwing2 = new ModelRenderer(this, 59, 11);
/* 235 */     this.Lwing2.addBox(-12.0F, 0.0F, -3.0F, 12, 0, 10);
/* 236 */     this.Lwing2.setRotationPoint(-6.0F, 12.6F, 0.0F);
/* 237 */     this.Lwing2.setTextureSize(64, 32);
/* 238 */     this.Lwing2.mirror = true;
/* 239 */     setRotation(this.Lwing2, 0.0F, 0.0F, 0.6981317F);
/* 240 */     this.Lwing3 = new ModelRenderer(this, 59, 22);
/* 241 */     this.Lwing3.addBox(-10.0F, 0.0F, -3.0F, 10, 0, 10);
/* 242 */     this.Lwing3.setRotationPoint(-6.0F, 12.6F, 0.0F);
/* 243 */     this.Lwing3.setTextureSize(64, 32);
/* 244 */     this.Lwing3.mirror = true;
/* 245 */     setRotation(this.Lwing3, 0.0F, 0.0F, 0.0698132F);
/* 246 */     this.Ljaw = new ModelRenderer(this, 30, 70);
/* 247 */     this.Ljaw.addBox(-1.5F, 1.0F, -5.0F, 3, 1, 5);
/* 248 */     this.Ljaw.setRotationPoint(4.5F, 7.0F, -7.0F);
/* 249 */     this.Ljaw.setTextureSize(64, 32);
/* 250 */     this.Ljaw.mirror = true;
/* 251 */     setRotation(this.Ljaw, 0.2443461F, 0.0F, 0.0F);
/* 252 */     this.jaw = new ModelRenderer(this, 30, 80);
/* 253 */     this.jaw.addBox(-1.5F, 1.0F, -5.0F, 3, 1, 5);
/* 254 */     this.jaw.setRotationPoint(0.0F, 7.0F, -7.0F);
/* 255 */     this.jaw.setTextureSize(64, 32);
/* 256 */     this.jaw.mirror = true;
/* 257 */     setRotation(this.jaw, 0.2443461F, 0.0F, 0.0F);
/* 258 */     this.Rjaw = new ModelRenderer(this, 30, 90);
/* 259 */     this.Rjaw.addBox(-1.5F, 1.0F, -5.0F, 3, 1, 5);
/* 260 */     this.Rjaw.setRotationPoint(-4.5F, 7.0F, -7.0F);
/* 261 */     this.Rjaw.setTextureSize(64, 32);
/* 262 */     this.Rjaw.mirror = true;
/* 263 */     setRotation(this.Rjaw, 0.2443461F, 0.0F, 0.0F);
/* 264 */     this.Lpower = new ModelRenderer(this, 30, 100);
/* 265 */     this.Lpower.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4);
/* 266 */     this.Lpower.setRotationPoint(4.5F, 17.0F, -5.0F);
/* 267 */     this.Lpower.setTextureSize(128, 128);
/* 268 */     this.Lpower.mirror = true;
/* 269 */     setRotation(this.Lpower, 0.0F, 0.0F, 0.0F);
/* 270 */     this.Cpower = new ModelRenderer(this, 50, 100);
/* 271 */     this.Cpower.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4);
/* 272 */     this.Cpower.setRotationPoint(0.0F, 17.0F, -5.0F);
/* 273 */     this.Cpower.setTextureSize(128, 128);
/* 274 */     this.Cpower.mirror = true;
/* 275 */     setRotation(this.Cpower, 0.0F, 0.0F, 0.0F);
/* 276 */     this.Rpower = new ModelRenderer(this, 70, 100);
/* 277 */     this.Rpower.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4);
/* 278 */     this.Rpower.setRotationPoint(-4.5F, 17.0F, -5.0F);
/* 279 */     this.Rpower.setTextureSize(128, 128);
/* 280 */     this.Rpower.mirror = true;
/* 281 */     setRotation(this.Rpower, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 289 */     ThePrincess c = (ThePrincess)entity;
/* 290 */     float hf = 0.0F;
/* 291 */     float newangle = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 295 */     int current_activity = c.getActivity();
/*     */     
/* 297 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 298 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */     
/* 302 */     if (f1 > 0.1D || c.getAttacking() != 0) {
/* 303 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/*     */     } else {
/* 305 */       newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.04F;
/*     */     } 
/*     */     
/* 308 */     this.Rwing.rotateAngleZ = newangle - 0.4F;
/* 309 */     this.Rwing2.rotateAngleZ = newangle - 0.6F;
/* 310 */     this.Rwing3.rotateAngleZ = newangle - 0.2F;
/* 311 */     this.Lwing.rotateAngleZ = -newangle + 0.4F;
/* 312 */     this.Lwing2.rotateAngleZ = -newangle + 0.6F;
/* 313 */     this.Lwing3.rotateAngleZ = -newangle + 0.2F;
/*     */ 
/*     */ 
/*     */     
/* 317 */     if (f1 > 0.1D) {
/* 318 */       newangle = MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 320 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 323 */     if (current_activity != 2 || c.getAttacking() != 0) {
/* 324 */       this.Rleg1.rotateAngleX = newangle;
/* 325 */       this.Lleg1.rotateAngleX = -newangle;
/*     */     } else {
/*     */       
/* 328 */       newangle = -1.0F;
/* 329 */       this.Rleg1.rotateAngleX = newangle;
/* 330 */       this.Lleg1.rotateAngleX = newangle;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 335 */     newangle = MathHelper.cos(f2 * 0.9F * this.wingspeed) * 3.1415927F * 0.06F;
/* 336 */     if (c.isSitting() == true) {
/* 337 */       newangle = 0.0F;
/*     */     }
/* 339 */     if (c.getAttacking() != 0) {
/* 340 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.12F;
/*     */     }
/* 342 */     this.tail2.rotateAngleY = newangle;
/*     */     
/* 344 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 6.0F;
/* 345 */     this.tail2.rotationPointX += (float)Math.sin(this.tail2.rotateAngleY) * 6.0F;
/* 346 */     this.tail3.rotateAngleY = newangle * 1.6F;
/*     */     
/* 348 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 5.0F;
/* 349 */     this.tail3.rotationPointX += (float)Math.sin(this.tail3.rotateAngleY) * 5.0F;
/* 350 */     this.tail4.rotateAngleY = newangle * 2.6F;
/*     */     
/* 352 */     this.tail4.rotationPointZ += (float)Math.cos(this.tail4.rotateAngleY) * 4.0F;
/* 353 */     this.tail4.rotationPointX += (float)Math.sin(this.tail4.rotateAngleY) * 4.0F;
/* 354 */     this.Tail5.rotateAngleY = newangle * 3.6F;
/*     */     
/* 356 */     this.Tail5.rotationPointZ += (float)Math.cos(this.Tail5.rotateAngleY) * 4.0F;
/* 357 */     this.Tail5.rotationPointX += (float)Math.sin(this.Tail5.rotateAngleY) * 4.0F;
/* 358 */     this.Tail6.rotateAngleY = newangle * 4.6F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     float h3 = f3 * 2.0F / 3.0F, h2 = h3, h1 = h2;
/* 364 */     float d3 = f4 * 2.0F / 3.0F, d2 = d3, d1 = d2;
/* 365 */     if (h1 < 0.0F) {
/* 366 */       h2 = h3 = h1 / 2.0F;
/* 367 */       d2 = d3 = d1 / 2.0F;
/*     */     } else {
/* 369 */       h2 = h1 = h3 / 2.0F;
/* 370 */       d2 = d1 = d3 / 2.0F;
/*     */     } 
/* 372 */     this.head.rotateAngleY = (float)Math.toRadians(h2);
/* 373 */     this.snout.rotateAngleY = (float)Math.toRadians(h2);
/* 374 */     this.headfin.rotateAngleY = (float)Math.toRadians(h2);
/* 375 */     this.jaw.rotateAngleY = (float)Math.toRadians(h2);
/* 376 */     this.snout.rotationPointZ -= (float)Math.cos(this.snout.rotateAngleY);
/* 377 */     this.snout.rotationPointX -= (float)Math.sin(this.snout.rotateAngleY);
/* 378 */     this.neck.rotateAngleY = (float)Math.toRadians(h2) / 2.0F;
/*     */     
/* 380 */     this.Lhead.rotateAngleY = (float)Math.toRadians(h1);
/* 381 */     this.Lsnout.rotateAngleY = (float)Math.toRadians(h1);
/* 382 */     this.Lheadfin.rotateAngleY = (float)Math.toRadians(h1);
/* 383 */     this.Ljaw.rotateAngleY = (float)Math.toRadians(h1);
/* 384 */     this.Lsnout.rotationPointZ -= (float)Math.cos(this.Lsnout.rotateAngleY);
/* 385 */     this.Lsnout.rotationPointX -= (float)Math.sin(this.Lsnout.rotateAngleY);
/* 386 */     this.Lneck.rotateAngleY = (float)Math.toRadians(h1) / 2.0F;
/*     */     
/* 388 */     this.Rhead.rotateAngleY = (float)Math.toRadians(h3);
/* 389 */     this.Rsnout.rotateAngleY = (float)Math.toRadians(h3);
/* 390 */     this.Rheadfin.rotateAngleY = (float)Math.toRadians(h3);
/* 391 */     this.Rjaw.rotateAngleY = (float)Math.toRadians(h3);
/* 392 */     this.Rsnout.rotationPointZ -= (float)Math.cos(this.Rsnout.rotateAngleY);
/* 393 */     this.Rsnout.rotationPointX -= (float)Math.sin(this.Rsnout.rotateAngleY);
/* 394 */     this.Rneck.rotateAngleY = (float)Math.toRadians(h3) / 2.0F;
/*     */     
/* 396 */     float Rjx = 0.0F, jx = Rjx, Ljx = jx;
/* 397 */     if (c.getAttacking() != 0) {
/* 398 */       newangle = MathHelper.cos(f2 * 1.9F * this.wingspeed) * 3.1415927F * 0.2F;
/* 399 */       Ljx = 0.2F + newangle;
/* 400 */       newangle = MathHelper.cos(f2 * 2.1F * this.wingspeed) * 3.1415927F * 0.2F;
/* 401 */       Rjx = 0.2F + newangle;
/* 402 */       newangle = MathHelper.cos(f2 * 2.3F * this.wingspeed) * 3.1415927F * 0.2F;
/* 403 */       jx = 0.2F + newangle;
/*     */     } 
/*     */ 
/*     */     
/* 407 */     this.head.rotateAngleX = (float)Math.toRadians(d2);
/* 408 */     this.snout.rotateAngleX = (float)Math.toRadians(d2);
/* 409 */     this.headfin.rotateAngleX = (float)Math.toRadians(d2);
/* 410 */     this.jaw.rotateAngleX = (float)Math.toRadians(d2) + jx;
/*     */     
/* 412 */     this.Lhead.rotateAngleX = (float)Math.toRadians(d1);
/* 413 */     this.Lsnout.rotateAngleX = (float)Math.toRadians(d1);
/* 414 */     this.Lheadfin.rotateAngleX = (float)Math.toRadians(d1);
/* 415 */     this.Ljaw.rotateAngleX = (float)Math.toRadians(d1) + Ljx;
/*     */     
/* 417 */     this.Rhead.rotateAngleX = (float)Math.toRadians(d3);
/* 418 */     this.Rsnout.rotateAngleX = (float)Math.toRadians(d3);
/* 419 */     this.Rheadfin.rotateAngleX = (float)Math.toRadians(d3);
/* 420 */     this.Rjaw.rotateAngleX = (float)Math.toRadians(d3) + Rjx;
/*     */ 
/*     */     
/* 423 */     d1 = c.getHead1Ext();
/* 424 */     d2 = c.getHead2Ext();
/* 425 */     d3 = c.getHead3Ext();
/*     */     
/* 427 */     this.Lneck.rotateAngleX = (float)Math.toRadians(d1);
/* 428 */     this.neck.rotateAngleX = (float)Math.toRadians(d2);
/* 429 */     this.Rneck.rotateAngleX = (float)Math.toRadians(d3);
/*     */     
/* 431 */     this.Lneck.rotationPointY -= (float)Math.cos(this.Lneck.rotateAngleX) * 7.0F;
/* 432 */     this.Ljaw.rotationPointY = this.Lhead.rotationPointY;
/* 433 */     this.Lneck.rotationPointZ -= (float)Math.sin(this.Lneck.rotateAngleX) * 7.0F;
/* 434 */     this.Ljaw.rotationPointZ = this.Lhead.rotationPointZ;
/* 435 */     this.Lneck.rotationPointX -= (float)Math.sin(this.Lneck.rotateAngleY) * 7.0F * (float)Math.sin(this.Lneck.rotateAngleX);
/* 436 */     this.Ljaw.rotationPointX = this.Lhead.rotationPointX;
/*     */     
/* 438 */     this.Rneck.rotationPointY -= (float)Math.cos(this.Rneck.rotateAngleX) * 7.0F;
/* 439 */     this.Rjaw.rotationPointY = this.Rhead.rotationPointY;
/* 440 */     this.Rneck.rotationPointZ -= (float)Math.sin(this.Rneck.rotateAngleX) * 7.0F;
/* 441 */     this.Rjaw.rotationPointZ = this.Rhead.rotationPointZ;
/* 442 */     this.Rneck.rotationPointX -= (float)Math.sin(this.Rneck.rotateAngleY) * 7.0F * (float)Math.sin(this.Rneck.rotateAngleX);
/* 443 */     this.Rjaw.rotationPointX = this.Rhead.rotationPointX;
/*     */     
/* 445 */     this.neck.rotationPointY -= (float)Math.cos(this.neck.rotateAngleX) * 7.0F;
/* 446 */     this.jaw.rotationPointY = this.head.rotationPointY;
/* 447 */     this.neck.rotationPointZ -= (float)Math.sin(this.neck.rotateAngleX) * 7.0F;
/* 448 */     this.jaw.rotationPointZ = this.head.rotationPointZ;
/* 449 */     this.neck.rotationPointX -= (float)Math.sin(this.neck.rotateAngleY) * 7.0F * (float)Math.sin(this.neck.rotateAngleX);
/* 450 */     this.jaw.rotationPointX = this.head.rotationPointX;
/*     */     
/* 452 */     this.Lpower.rotateAngleX += 0.03F;
/* 453 */     if (this.Lpower.rotateAngleX > Math.PI) this.Lpower.rotateAngleX = (float)(this.Lpower.rotateAngleX - 6.283185307179586D); 
/* 454 */     this.Cpower.rotateAngleX += 0.04F;
/* 455 */     if (this.Cpower.rotateAngleX > Math.PI) this.Cpower.rotateAngleX = (float)(this.Cpower.rotateAngleX - 6.283185307179586D); 
/* 456 */     this.Rpower.rotateAngleX += 0.05F;
/* 457 */     if (this.Rpower.rotateAngleX > Math.PI) this.Rpower.rotateAngleX = (float)(this.Rpower.rotateAngleX - 6.283185307179586D);
/*     */     
/* 459 */     this.Lpower.rotateAngleY += 0.035F;
/* 460 */     if (this.Lpower.rotateAngleY > Math.PI) this.Lpower.rotateAngleY = (float)(this.Lpower.rotateAngleY - 6.283185307179586D); 
/* 461 */     this.Cpower.rotateAngleY += 0.046F;
/* 462 */     if (this.Cpower.rotateAngleY > Math.PI) this.Cpower.rotateAngleY = (float)(this.Cpower.rotateAngleY - 6.283185307179586D); 
/* 463 */     this.Rpower.rotateAngleY += 0.065F;
/* 464 */     if (this.Rpower.rotateAngleY > Math.PI) this.Rpower.rotateAngleY = (float)(this.Rpower.rotateAngleY - 6.283185307179586D);
/*     */     
/* 466 */     this.Lpower.rotateAngleZ += 0.05F;
/* 467 */     if (this.Lpower.rotateAngleZ > Math.PI) this.Lpower.rotateAngleZ = (float)(this.Lpower.rotateAngleZ - 6.283185307179586D); 
/* 468 */     this.Cpower.rotateAngleZ += 0.13F;
/* 469 */     if (this.Cpower.rotateAngleZ > Math.PI) this.Cpower.rotateAngleZ = (float)(this.Cpower.rotateAngleZ - 6.283185307179586D); 
/* 470 */     this.Rpower.rotateAngleZ += 0.03F;
/* 471 */     if (this.Rpower.rotateAngleZ > Math.PI) this.Rpower.rotateAngleZ = (float)(this.Rpower.rotateAngleZ - 6.283185307179586D);
/*     */     
/* 473 */     this.body.render(f5);
/* 474 */     this.neck1.render(f5);
/* 475 */     this.neck.render(f5);
/* 476 */     this.neckbase.render(f5);
/* 477 */     this.head.render(f5);
/* 478 */     this.Rleg1.render(f5);
/* 479 */     this.Lleg1.render(f5);
/* 480 */     this.snout.render(f5);
/* 481 */     this.tail2.render(f5);
/* 482 */     this.tail3.render(f5);
/* 483 */     this.tail4.render(f5);
/* 484 */     this.Tail5.render(f5);
/* 485 */     this.Tail6.render(f5);
/* 486 */     this.Lneck1.render(f5);
/* 487 */     this.Lneck.render(f5);
/* 488 */     this.Lhead.render(f5);
/* 489 */     this.Lsnout.render(f5);
/* 490 */     this.Rneck1.render(f5);
/* 491 */     this.Rneck.render(f5);
/* 492 */     this.Rhead.render(f5);
/* 493 */     this.Rsnout.render(f5);
/* 494 */     this.headfin.render(f5);
/* 495 */     this.Lheadfin.render(f5);
/* 496 */     this.Rheadfin.render(f5);
/* 497 */     this.Backfin.render(f5);
/* 498 */     this.Ljaw.render(f5);
/* 499 */     this.jaw.render(f5);
/* 500 */     this.Rjaw.render(f5);
/*     */ 
/*     */     
/* 503 */     GL11.glPushMatrix();
/* 504 */     GL11.glEnable(2977);
/* 505 */     GL11.glEnable(3042);
/* 506 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 508 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.55F);
/* 509 */     this.Rwing2.render(f5);
/* 510 */     this.Rwing3.render(f5);
/* 511 */     this.Lwing2.render(f5);
/* 512 */     this.Lwing3.render(f5);
/* 513 */     this.Lwing.render(f5);
/* 514 */     this.Rwing.render(f5);
/* 515 */     OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
/* 516 */     this.Lpower.render(f5);
/* 517 */     this.Cpower.render(f5);
/* 518 */     this.Rpower.render(f5);
/* 519 */     GL11.glDisable(3042);
/* 520 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 525 */     model.rotateAngleX = x;
/* 526 */     model.rotateAngleY = y;
/* 527 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 532 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelThePrincess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */