/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelEnderKnight
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer rleg1;
/*     */   ModelRenderer rleg3;
/*     */   ModelRenderer pelvis;
/*     */   ModelRenderer spine1;
/*     */   ModelRenderer spine2;
/*     */   ModelRenderer spine3;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer rleg2;
/*     */   ModelRenderer rhip;
/*     */   ModelRenderer rib4;
/*     */   ModelRenderer rib3;
/*     */   ModelRenderer rib2;
/*     */   ModelRenderer rib1;
/*     */   ModelRenderer rfoot1;
/*     */   ModelRenderer rfoot3;
/*     */   ModelRenderer rcollar;
/*     */   ModelRenderer lcollar;
/*     */   ModelRenderer lleg3;
/*     */   ModelRenderer lleg2;
/*     */   ModelRenderer lhip;
/*     */   ModelRenderer lleg1;
/*     */   ModelRenderer rfoot4;
/*     */   ModelRenderer rfoot2;
/*     */   ModelRenderer cape2;
/*     */   ModelRenderer cape1;
/*     */   ModelRenderer lfoot1;
/*     */   ModelRenderer lfoot3;
/*     */   ModelRenderer lfoot2;
/*     */   ModelRenderer lfoot4;
/*     */   ModelRenderer head;
/*     */   ModelRenderer lshoulder;
/*     */   ModelRenderer rshoulder;
/*     */   ModelRenderer rarm3;
/*     */   ModelRenderer rarm2;
/*     */   ModelRenderer rarm1;
/*     */   ModelRenderer larm3;
/*     */   ModelRenderer larm2;
/*     */   ModelRenderer larm1;
/*     */   ModelRenderer blade;
/*     */   ModelRenderer handle;
/*  51 */   private float wingspeed = 1.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelEnderKnight(float f1) {
/*  56 */     this.wingspeed = f1;
/*     */     
/*  58 */     this.textureWidth = 512;
/*  59 */     this.textureHeight = 512;
/*     */     
/*  61 */     this.rleg1 = new ModelRenderer(this, 20, 50);
/*  62 */     this.rleg1.addBox(0.0F, 12.0F, -1.0F, 1, 15, 1);
/*  63 */     this.rleg1.setRotationPoint(-7.0F, -5.0F, -2.0F);
/*  64 */     this.rleg1.setTextureSize(512, 512);
/*  65 */     this.rleg1.mirror = true;
/*  66 */     setRotation(this.rleg1, 0.0F, 0.0F, 0.0F);
/*  67 */     this.rleg3 = new ModelRenderer(this, 20, 100);
/*  68 */     this.rleg3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 2);
/*  69 */     this.rleg3.setRotationPoint(-6.0F, -5.0F, -2.0F);
/*  70 */     this.rleg3.setTextureSize(512, 512);
/*  71 */     this.rleg3.mirror = true;
/*  72 */     setRotation(this.rleg3, -0.1F, 0.0F, 0.0F);
/*  73 */     this.pelvis = new ModelRenderer(this, 20, 150);
/*  74 */     this.pelvis.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
/*  75 */     this.pelvis.setRotationPoint(-5.0F, -6.0F, -2.0F);
/*  76 */     this.pelvis.setTextureSize(512, 512);
/*  77 */     this.pelvis.mirror = true;
/*  78 */     setRotation(this.pelvis, 0.0F, 0.0F, 0.0F);
/*  79 */     this.spine1 = new ModelRenderer(this, 20, 200);
/*  80 */     this.spine1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  81 */     this.spine1.setRotationPoint(-4.0F, -9.0F, 1.0F);
/*  82 */     this.spine1.setTextureSize(512, 512);
/*  83 */     this.spine1.mirror = true;
/*  84 */     setRotation(this.spine1, -0.3F, 0.0F, 0.0F);
/*  85 */     this.spine2 = new ModelRenderer(this, 20, 250);
/*  86 */     this.spine2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  87 */     this.spine2.setRotationPoint(-4.0F, -13.0F, 1.0F);
/*  88 */     this.spine2.setTextureSize(512, 512);
/*  89 */     this.spine2.mirror = true;
/*  90 */     setRotation(this.spine2, 0.0F, 0.0F, 0.0F);
/*  91 */     this.spine3 = new ModelRenderer(this, 20, 300);
/*  92 */     this.spine3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  93 */     this.spine3.setRotationPoint(-4.0F, -17.0F, 0.0F);
/*  94 */     this.spine3.setTextureSize(512, 512);
/*  95 */     this.spine3.mirror = true;
/*  96 */     setRotation(this.spine3, 0.2F, 0.0F, 0.0F);
/*  97 */     this.neck = new ModelRenderer(this, 20, 11);
/*  98 */     this.neck.addBox(0.0F, 0.0F, 0.0F, 5, 3, 3);
/*  99 */     this.neck.setRotationPoint(-6.0F, -20.0F, 0.0F);
/* 100 */     this.neck.setTextureSize(512, 512);
/* 101 */     this.neck.mirror = true;
/* 102 */     setRotation(this.neck, 0.0F, 0.0F, 0.0F);
/* 103 */     this.rleg2 = new ModelRenderer(this, 20, 400);
/* 104 */     this.rleg2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 2);
/* 105 */     this.rleg2.setRotationPoint(-8.0F, -5.0F, -2.0F);
/* 106 */     this.rleg2.setTextureSize(512, 512);
/* 107 */     this.rleg2.mirror = true;
/* 108 */     setRotation(this.rleg2, -0.1F, 0.0F, 0.0F);
/* 109 */     this.rhip = new ModelRenderer(this, 20, 450);
/* 110 */     this.rhip.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/* 111 */     this.rhip.setRotationPoint(-7.0F, -4.0F, -2.0F);
/* 112 */     this.rhip.setTextureSize(512, 512);
/* 113 */     this.rhip.mirror = true;
/* 114 */     setRotation(this.rhip, 0.0F, 0.0F, 0.0F);
/* 115 */     this.rib4 = new ModelRenderer(this, 20, 79);
/* 116 */     this.rib4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 117 */     this.rib4.setRotationPoint(-5.0F, -9.0F, 1.0F);
/* 118 */     this.rib4.setTextureSize(512, 512);
/* 119 */     this.rib4.mirror = true;
/* 120 */     setRotation(this.rib4, 0.0F, 0.0F, 0.0F);
/* 121 */     this.rib3 = new ModelRenderer(this, 20, 86);
/* 122 */     this.rib3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 123 */     this.rib3.setRotationPoint(-5.0F, -11.0F, 1.0F);
/* 124 */     this.rib3.setTextureSize(512, 512);
/* 125 */     this.rib3.mirror = true;
/* 126 */     setRotation(this.rib3, 0.0F, 0.0F, 0.0F);
/* 127 */     this.rib2 = new ModelRenderer(this, 20, 94);
/* 128 */     this.rib2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
/* 129 */     this.rib2.setRotationPoint(-6.0F, -13.0F, 1.0F);
/* 130 */     this.rib2.setTextureSize(512, 512);
/* 131 */     this.rib2.mirror = true;
/* 132 */     setRotation(this.rib2, 0.0F, 0.0F, 0.0F);
/* 133 */     this.rib1 = new ModelRenderer(this, 20, 122);
/* 134 */     this.rib1.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
/* 135 */     this.rib1.setRotationPoint(-6.0F, -16.0F, 0.0F);
/* 136 */     this.rib1.setTextureSize(512, 512);
/* 137 */     this.rib1.mirror = true;
/* 138 */     setRotation(this.rib1, 0.0F, 0.0F, 0.0F);
/* 139 */     this.rfoot1 = new ModelRenderer(this, 20, 131);
/* 140 */     this.rfoot1.addBox(0.0F, 21.0F, -2.0F, 3, 8, 3);
/* 141 */     this.rfoot1.setRotationPoint(-8.0F, -5.0F, -2.0F);
/* 142 */     this.rfoot1.setTextureSize(512, 512);
/* 143 */     this.rfoot1.mirror = true;
/* 144 */     setRotation(this.rfoot1, 0.0F, 0.0F, 0.0F);
/* 145 */     this.rfoot3 = new ModelRenderer(this, 20, 162);
/* 146 */     this.rfoot3.addBox(0.0F, 27.0F, -5.0F, 3, 2, 6);
/* 147 */     this.rfoot3.setRotationPoint(-8.0F, -5.0F, -2.0F);
/* 148 */     this.rfoot3.setTextureSize(512, 512);
/* 149 */     this.rfoot3.mirror = true;
/* 150 */     setRotation(this.rfoot3, 0.0F, 0.0F, 0.0F);
/* 151 */     this.rcollar = new ModelRenderer(this, 20, 243);
/* 152 */     this.rcollar.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
/* 153 */     this.rcollar.setRotationPoint(-11.0F, -19.0F, 1.0F);
/* 154 */     this.rcollar.setTextureSize(512, 512);
/* 155 */     this.rcollar.mirror = true;
/* 156 */     setRotation(this.rcollar, 0.0F, 0.0F, 0.0F);
/* 157 */     this.lcollar = new ModelRenderer(this, 20, 286);
/* 158 */     this.lcollar.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
/* 159 */     this.lcollar.setRotationPoint(-1.0F, -19.0F, 1.0F);
/* 160 */     this.lcollar.setTextureSize(512, 512);
/* 161 */     this.lcollar.mirror = true;
/* 162 */     setRotation(this.lcollar, 0.0F, 0.0F, 0.0F);
/* 163 */     this.lleg3 = new ModelRenderer(this, 48, 159);
/* 164 */     this.lleg3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 2);
/* 165 */     this.lleg3.setRotationPoint(-2.0F, -5.0F, -2.0F);
/* 166 */     this.lleg3.setTextureSize(512, 512);
/* 167 */     this.lleg3.mirror = true;
/* 168 */     setRotation(this.lleg3, -0.1F, 0.0F, 0.0F);
/* 169 */     this.lleg2 = new ModelRenderer(this, 28, 187);
/* 170 */     this.lleg2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 2);
/* 171 */     this.lleg2.setRotationPoint(0.0F, -5.0F, -2.0F);
/* 172 */     this.lleg2.setTextureSize(512, 512);
/* 173 */     this.lleg2.mirror = true;
/* 174 */     setRotation(this.lleg2, -0.1F, 0.0F, 0.0F);
/* 175 */     this.lhip = new ModelRenderer(this, 32, 219);
/* 176 */     this.lhip.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/* 177 */     this.lhip.setRotationPoint(-1.0F, -4.0F, -2.0F);
/* 178 */     this.lhip.setTextureSize(512, 512);
/* 179 */     this.lhip.mirror = true;
/* 180 */     setRotation(this.lhip, 0.0F, 0.0F, 0.0F);
/* 181 */     this.lleg1 = new ModelRenderer(this, 36, 224);
/* 182 */     this.lleg1.addBox(0.0F, 12.0F, -1.0F, 1, 15, 1);
/* 183 */     this.lleg1.setRotationPoint(-1.0F, -5.0F, -2.0F);
/* 184 */     this.lleg1.setTextureSize(512, 512);
/* 185 */     this.lleg1.mirror = true;
/* 186 */     setRotation(this.lleg1, 0.0F, 0.0F, 0.0F);
/* 187 */     this.rfoot4 = new ModelRenderer(this, 33, 254);
/* 188 */     this.rfoot4.addBox(0.0F, 26.0F, -3.0F, 3, 1, 1);
/* 189 */     this.rfoot4.setRotationPoint(-8.0F, -5.0F, -2.0F);
/* 190 */     this.rfoot4.setTextureSize(512, 512);
/* 191 */     this.rfoot4.mirror = true;
/* 192 */     setRotation(this.rfoot4, 0.0F, 0.0F, 0.0F);
/* 193 */     this.rfoot2 = new ModelRenderer(this, 32, 36);
/* 194 */     this.rfoot2.addBox(0.0F, 19.5F, -19.0F, 3, 1, 5);
/* 195 */     this.rfoot2.setRotationPoint(-8.0F, -5.0F, -2.0F);
/* 196 */     this.rfoot2.setTextureSize(512, 512);
/* 197 */     this.rfoot2.mirror = true;
/* 198 */     setRotation(this.rfoot2, 0.6F, 0.0F, 0.0F);
/* 199 */     this.cape2 = new ModelRenderer(this, 51, 276);
/* 200 */     this.cape2.addBox(-4.0F, 0.0F, 0.0F, 9, 24, 0);
/* 201 */     this.cape2.setRotationPoint(-4.0F, -20.0F, 4.0F);
/* 202 */     this.cape2.setTextureSize(512, 512);
/* 203 */     this.cape2.mirror = true;
/* 204 */     setRotation(this.cape2, 0.0F, 0.0F, 0.0F);
/* 205 */     this.cape1 = new ModelRenderer(this, 51, 264);
/* 206 */     this.cape1.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
/* 207 */     this.cape1.setRotationPoint(-8.0F, -20.0F, 3.0F);
/* 208 */     this.cape1.setTextureSize(512, 512);
/* 209 */     this.cape1.mirror = true;
/* 210 */     setRotation(this.cape1, 0.0F, 0.0F, 0.0F);
/* 211 */     this.lfoot1 = new ModelRenderer(this, 44, 182);
/* 212 */     this.lfoot1.addBox(0.0F, 21.0F, -2.0F, 3, 8, 3);
/* 213 */     this.lfoot1.setRotationPoint(-2.0F, -5.0F, -2.0F);
/* 214 */     this.lfoot1.setTextureSize(512, 512);
/* 215 */     this.lfoot1.mirror = true;
/* 216 */     setRotation(this.lfoot1, 0.0F, 0.0F, 0.0F);
/* 217 */     this.lfoot3 = new ModelRenderer(this, 52, 200);
/* 218 */     this.lfoot3.addBox(0.0F, 27.0F, -5.0F, 3, 2, 6);
/* 219 */     this.lfoot3.setRotationPoint(-2.0F, -5.0F, -2.0F);
/* 220 */     this.lfoot3.setTextureSize(512, 512);
/* 221 */     this.lfoot3.mirror = true;
/* 222 */     setRotation(this.lfoot3, 0.0F, 0.0F, 0.0F);
/* 223 */     this.lfoot2 = new ModelRenderer(this, 52, 218);
/* 224 */     this.lfoot2.addBox(0.0F, 19.5F, -19.0F, 3, 1, 5);
/* 225 */     this.lfoot2.setRotationPoint(-2.0F, -5.0F, -2.0F);
/* 226 */     this.lfoot2.setTextureSize(512, 512);
/* 227 */     this.lfoot2.mirror = true;
/* 228 */     setRotation(this.lfoot2, 0.6F, 0.0F, 0.0F);
/* 229 */     this.lfoot4 = new ModelRenderer(this, 48, 235);
/* 230 */     this.lfoot4.addBox(0.0F, 26.0F, -3.0F, 3, 1, 1);
/* 231 */     this.lfoot4.setRotationPoint(-2.0F, -5.0F, -2.0F);
/* 232 */     this.lfoot4.setTextureSize(512, 512);
/* 233 */     this.lfoot4.mirror = true;
/* 234 */     setRotation(this.lfoot4, 0.0F, 0.0F, 0.0F);
/* 235 */     this.head = new ModelRenderer(this, 34, 106);
/* 236 */     this.head.addBox(-4.0F, -8.0F, -4.0F, 7, 6, 6);
/* 237 */     this.head.setRotationPoint(-3.0F, -18.0F, 3.0F);
/* 238 */     this.head.setTextureSize(512, 512);
/* 239 */     this.head.mirror = true;
/* 240 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 241 */     this.lshoulder = new ModelRenderer(this, 48, 16);
/* 242 */     this.lshoulder.addBox(0.0F, 0.0F, 0.0F, 5, 4, 4);
/* 243 */     this.lshoulder.setRotationPoint(2.0F, -21.0F, 0.0F);
/* 244 */     this.lshoulder.setTextureSize(512, 512);
/* 245 */     this.lshoulder.mirror = true;
/* 246 */     setRotation(this.lshoulder, 0.0F, 0.0F, 0.0F);
/* 247 */     this.rshoulder = new ModelRenderer(this, 48, 16);
/* 248 */     this.rshoulder.addBox(0.0F, 0.0F, 0.0F, 5, 4, 4);
/* 249 */     this.rshoulder.setRotationPoint(-14.0F, -21.0F, 0.0F);
/* 250 */     this.rshoulder.setTextureSize(512, 512);
/* 251 */     this.rshoulder.mirror = true;
/* 252 */     setRotation(this.rshoulder, 0.0F, 0.0F, 0.0F);
/* 253 */     this.rarm3 = new ModelRenderer(this, 39, 64);
/* 254 */     this.rarm3.addBox(0.0F, 0.0F, 0.0F, 1, 12, 1);
/* 255 */     this.rarm3.setRotationPoint(-11.0F, -18.0F, 1.0F);
/* 256 */     this.rarm3.setTextureSize(512, 512);
/* 257 */     this.rarm3.mirror = true;
/* 258 */     setRotation(this.rarm3, -0.5F, 0.0F, 0.0F);
/* 259 */     this.rarm2 = new ModelRenderer(this, 57, 62);
/* 260 */     this.rarm2.addBox(0.0F, 0.0F, 0.0F, 1, 12, 1);
/* 261 */     this.rarm2.setRotationPoint(-13.0F, -18.0F, 1.0F);
/* 262 */     this.rarm2.setTextureSize(512, 512);
/* 263 */     this.rarm2.mirror = true;
/* 264 */     setRotation(this.rarm2, -0.5F, 0.0F, 0.0F);
/* 265 */     this.rarm1 = new ModelRenderer(this, 49, 81);
/* 266 */     this.rarm1.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
/* 267 */     this.rarm1.setRotationPoint(-12.0F, -18.0F, 2.0F);
/* 268 */     this.rarm1.setTextureSize(512, 512);
/* 269 */     this.rarm1.mirror = true;
/* 270 */     setRotation(this.rarm1, -1.0F, -1.0F, 0.0F);
/* 271 */     this.larm3 = new ModelRenderer(this, 49, 129);
/* 272 */     this.larm3.addBox(0.0F, 0.0F, 0.0F, 1, 12, 1);
/* 273 */     this.larm3.setRotationPoint(3.0F, -18.0F, 1.0F);
/* 274 */     this.larm3.setTextureSize(512, 512);
/* 275 */     this.larm3.mirror = true;
/* 276 */     setRotation(this.larm3, -0.5F, 0.0F, 0.0F);
/* 277 */     this.larm2 = new ModelRenderer(this, 64, 133);
/* 278 */     this.larm2.addBox(0.0F, 0.0F, 0.0F, 1, 12, 1);
/* 279 */     this.larm2.setRotationPoint(5.0F, -18.0F, 1.0F);
/* 280 */     this.larm2.setTextureSize(512, 512);
/* 281 */     this.larm2.mirror = true;
/* 282 */     setRotation(this.larm2, -0.5F, 0.0F, 0.0F);
/* 283 */     this.larm1 = new ModelRenderer(this, 22, 316);
/* 284 */     this.larm1.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
/* 285 */     this.larm1.setRotationPoint(4.0F, -18.0F, 1.0F);
/* 286 */     this.larm1.setTextureSize(512, 512);
/* 287 */     this.larm1.mirror = true;
/* 288 */     setRotation(this.larm1, -1.0F, 1.0F, 0.0F);
/* 289 */     this.blade = new ModelRenderer(this, 36, 304);
/* 290 */     this.blade.addBox(0.0F, -34.0F, -2.0F, 1, 32, 6);
/* 291 */     this.blade.setRotationPoint(-4.0F, -2.0F, -8.0F);
/* 292 */     this.blade.setTextureSize(512, 512);
/* 293 */     this.blade.mirror = true;
/* 294 */     setRotation(this.blade, 0.35F, 0.0F, 0.0F);
/* 295 */     this.handle = new ModelRenderer(this, 18, 26);
/* 296 */     this.handle.addBox(0.0F, -2.0F, 0.0F, 1, 4, 1);
/* 297 */     this.handle.setRotationPoint(-4.0F, -2.0F, -8.0F);
/* 298 */     this.handle.setTextureSize(512, 512);
/* 299 */     this.handle.mirror = true;
/* 300 */     setRotation(this.handle, 0.35F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 305 */     EnderKnight e = (EnderKnight)entity;
/* 306 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 307 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 308 */     float newangle = 0.0F;
/*     */     
/* 310 */     if (f1 > 0.1D) {
/* 311 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 313 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 316 */     this.lfoot1.rotateAngleX = newangle;
/* 317 */     this.lfoot2.rotateAngleX = 0.6F + newangle;
/* 318 */     this.lfoot3.rotateAngleX = newangle;
/* 319 */     this.lfoot4.rotateAngleX = newangle;
/* 320 */     this.lleg1.rotateAngleX = newangle;
/* 321 */     this.lleg2.rotateAngleX = -0.1F + newangle;
/* 322 */     this.lleg3.rotateAngleX = -0.1F + newangle;
/* 323 */     this.rfoot1.rotateAngleX = -newangle;
/* 324 */     this.rfoot2.rotateAngleX = 0.6F - newangle;
/* 325 */     this.rfoot3.rotateAngleX = -newangle;
/* 326 */     this.rfoot4.rotateAngleX = -newangle;
/* 327 */     this.rleg1.rotateAngleX = -newangle;
/* 328 */     this.rleg2.rotateAngleX = -0.1F - newangle;
/* 329 */     this.rleg3.rotateAngleX = -0.1F - newangle;
/* 330 */     this.cape2.rotateAngleZ = newangle / 4.0F;
/*     */     
/* 332 */     newangle = MathHelper.cos(f2 * 0.7F * this.wingspeed) * 3.1415927F * 0.02F;
/* 333 */     this.cape2.rotateAngleX = newangle;
/*     */     
/* 335 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 336 */     if (this.head.rotateAngleY > 0.45F) this.head.rotateAngleY = 0.45F; 
/* 337 */     if (this.head.rotateAngleY < -0.45F) this.head.rotateAngleY = -0.45F;
/*     */     
/* 339 */     newangle = MathHelper.cos(f2 * 2.7F * this.wingspeed) * 3.1415927F * 0.3F;
/* 340 */     if (e.isScreaming()) {
/* 341 */       this.larm2.rotateAngleX = -1.2F + newangle;
/* 342 */       this.larm3.rotateAngleX = -1.2F + newangle;
/* 343 */       this.rarm2.rotateAngleX = -1.2F + newangle;
/* 344 */       this.rarm3.rotateAngleX = -1.2F + newangle;
/* 345 */       this.larm1.rotateAngleX = -1.8F + newangle;
/* 346 */       this.rarm1.rotateAngleX = -1.8F + newangle;
/* 347 */       this.handle.rotateAngleX = 0.5F + newangle * 3.0F / 2.0F;
/*     */     } else {
/* 349 */       this.larm2.rotateAngleX = -0.5F;
/* 350 */       this.larm3.rotateAngleX = -0.5F;
/* 351 */       this.larm1.rotateAngleZ = 0.0F;
/* 352 */       this.larm1.rotateAngleY = 1.0F;
/* 353 */       this.larm1.rotateAngleX = -1.0F;
/* 354 */       this.rarm2.rotateAngleX = -0.5F;
/* 355 */       this.rarm3.rotateAngleX = -0.5F;
/* 356 */       this.rarm1.rotateAngleZ = 0.0F;
/* 357 */       this.rarm1.rotateAngleY = -1.0F;
/* 358 */       this.rarm1.rotateAngleX = -1.0F;
/* 359 */       this.handle.rotateAngleX = 0.35F;
/*     */     } 
/* 361 */     this.larm1.rotationPointY = (float)(this.larm2.rotationPointY + Math.cos(this.larm2.rotateAngleX) * 10.0D);
/* 362 */     this.larm1.rotationPointZ = (float)(this.larm2.rotationPointZ + Math.sin(this.larm2.rotateAngleX) * 10.0D);
/* 363 */     this.rarm1.rotationPointY = (float)(this.rarm2.rotationPointY + Math.cos(this.rarm2.rotateAngleX) * 10.0D);
/* 364 */     this.rarm1.rotationPointZ = (float)(this.rarm2.rotationPointZ + Math.sin(this.rarm2.rotateAngleX) * 10.0D);
/* 365 */     this.handle.rotationPointY = (float)(this.rarm1.rotationPointY + Math.cos(this.rarm1.rotateAngleX) * 7.0D) + 1.0F;
/* 366 */     this.handle.rotationPointZ = (float)(this.rarm1.rotationPointZ + Math.sin(this.rarm1.rotateAngleX) * 7.0D);
/*     */     
/* 368 */     this.rleg1.render(f5);
/* 369 */     this.rleg3.render(f5);
/* 370 */     this.pelvis.render(f5);
/* 371 */     this.spine1.render(f5);
/* 372 */     this.spine2.render(f5);
/* 373 */     this.spine3.render(f5);
/* 374 */     this.neck.render(f5);
/* 375 */     this.rleg2.render(f5);
/* 376 */     this.rhip.render(f5);
/* 377 */     this.rib4.render(f5);
/* 378 */     this.rib3.render(f5);
/* 379 */     this.rib2.render(f5);
/* 380 */     this.rib1.render(f5);
/* 381 */     this.rfoot1.render(f5);
/* 382 */     this.rfoot3.render(f5);
/* 383 */     this.rcollar.render(f5);
/* 384 */     this.lcollar.render(f5);
/* 385 */     this.lleg3.render(f5);
/* 386 */     this.lleg2.render(f5);
/* 387 */     this.lhip.render(f5);
/* 388 */     this.lleg1.render(f5);
/* 389 */     this.rfoot4.render(f5);
/* 390 */     this.rfoot2.render(f5);
/* 391 */     this.cape2.render(f5);
/* 392 */     this.cape1.render(f5);
/* 393 */     this.lfoot1.render(f5);
/* 394 */     this.lfoot3.render(f5);
/* 395 */     this.lfoot2.render(f5);
/* 396 */     this.lfoot4.render(f5);
/* 397 */     this.head.render(f5);
/* 398 */     this.lshoulder.render(f5);
/* 399 */     this.rshoulder.render(f5);
/* 400 */     this.rarm3.render(f5);
/* 401 */     this.rarm2.render(f5);
/* 402 */     this.rarm1.render(f5);
/* 403 */     this.larm3.render(f5);
/* 404 */     this.larm2.render(f5);
/* 405 */     this.larm1.render(f5);
/* 406 */     this.blade.render(f5);
/* 407 */     this.handle.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 413 */     model.rotateAngleX = x;
/* 414 */     model.rotateAngleY = y;
/* 415 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 420 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelEnderKnight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */