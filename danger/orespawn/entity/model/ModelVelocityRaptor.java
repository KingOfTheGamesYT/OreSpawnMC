/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.VelocityRaptor;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelVelocityRaptor
/*     */   extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer hf3;
/*     */   
/*     */   ModelRenderer hf4;
/*     */   ModelRenderer hf2;
/*     */   ModelRenderer hf1;
/*     */   ModelRenderer lff2;
/*     */   ModelRenderer lff1;
/*     */   ModelRenderer lff3;
/*     */   ModelRenderer rff2;
/*     */   ModelRenderer rff3;
/*     */   ModelRenderer rff1;
/*     */   ModelRenderer tf4;
/*     */   ModelRenderer tf1;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer head1;
/*     */   ModelRenderer lf1;
/*     */   ModelRenderer lf2;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer bl1;
/*     */   ModelRenderer br1;
/*     */   ModelRenderer bl2;
/*     */   ModelRenderer br2;
/*     */   ModelRenderer bl3;
/*     */   ModelRenderer bl4;
/*     */   ModelRenderer br3;
/*     */   ModelRenderer rf1;
/*     */   ModelRenderer rf2;
/*     */   ModelRenderer tf2;
/*     */   ModelRenderer tf3;
/*     */   ModelRenderer br4;
/*     */   ModelRenderer Hat1;
/*     */   ModelRenderer Hat2;
/*     */   
/*     */   public ModelVelocityRaptor(float f1) {
/*  50 */     this.wingspeed = f1;
/*     */     
/*  52 */     this.textureWidth = 128;
/*  53 */     this.textureHeight = 128;
/*     */     
/*  55 */     this.hf3 = new ModelRenderer(this, 0, 0);
/*  56 */     this.hf3.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3);
/*  57 */     this.hf3.setRotationPoint(0.0F, 7.0F, -2.0F);
/*  58 */     this.hf3.setTextureSize(128, 128);
/*  59 */     this.hf3.mirror = true;
/*  60 */     setRotation(this.hf3, 0.4537856F, 0.0F, 0.0F);
/*  61 */     this.hf4 = new ModelRenderer(this, 0, 0);
/*  62 */     this.hf4.addBox(0.0F, -0.2F, 0.0F, 0, 1, 3);
/*  63 */     this.hf4.setRotationPoint(0.0F, 8.0F, -1.5F);
/*  64 */     this.hf4.setTextureSize(128, 128);
/*  65 */     this.hf4.mirror = true;
/*  66 */     setRotation(this.hf4, 0.2443461F, 0.0F, 0.0F);
/*  67 */     this.hf2 = new ModelRenderer(this, 0, 0);
/*  68 */     this.hf2.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3);
/*  69 */     this.hf2.setRotationPoint(0.0F, 7.0F, -3.5F);
/*  70 */     this.hf2.setTextureSize(128, 128);
/*  71 */     this.hf2.mirror = true;
/*  72 */     setRotation(this.hf2, 0.6632251F, 0.0F, 0.0F);
/*  73 */     this.hf1 = new ModelRenderer(this, 0, 1);
/*  74 */     this.hf1.addBox(0.0F, 0.0F, 0.0F, 0, 1, 2);
/*  75 */     this.hf1.setRotationPoint(0.0F, 7.0F, -4.5F);
/*  76 */     this.hf1.setTextureSize(128, 128);
/*  77 */     this.hf1.mirror = true;
/*  78 */     setRotation(this.hf1, 0.9424778F, 0.0F, 0.0F);
/*  79 */     this.lff2 = new ModelRenderer(this, 0, 6);
/*  80 */     this.lff2.addBox(0.5F, 2.5F, 3.0F, 0, 1, 3);
/*  81 */     this.lff2.setRotationPoint(2.0F, 14.0F, 1.0F);
/*  82 */     this.lff2.setTextureSize(128, 128);
/*  83 */     this.lff2.mirror = true;
/*  84 */     setRotation(this.lff2, -0.4537856F, 0.0F, 0.0F);
/*  85 */     this.lff1 = new ModelRenderer(this, 0, 6);
/*  86 */     this.lff1.addBox(0.5F, 2.0F, 2.0F, 0, 1, 3);
/*  87 */     this.lff1.setRotationPoint(2.0F, 14.0F, 1.0F);
/*  88 */     this.lff1.setTextureSize(128, 128);
/*  89 */     this.lff1.mirror = true;
/*  90 */     setRotation(this.lff1, -0.2792527F, 0.0F, 0.0F);
/*  91 */     this.lff3 = new ModelRenderer(this, 0, 6);
/*  92 */     this.lff3.addBox(0.5F, 1.0F, 4.0F, 0, 1, 3);
/*  93 */     this.lff3.setRotationPoint(2.0F, 14.0F, 1.0F);
/*  94 */     this.lff3.setTextureSize(128, 128);
/*  95 */     this.lff3.mirror = true;
/*  96 */     setRotation(this.lff3, -1.047198F, 0.0F, 0.0F);
/*  97 */     this.rff2 = new ModelRenderer(this, 0, 6);
/*  98 */     this.rff2.addBox(-0.5F, 2.5F, 3.0F, 0, 1, 3);
/*  99 */     this.rff2.setRotationPoint(-2.0F, 14.0F, 1.0F);
/* 100 */     this.rff2.setTextureSize(128, 128);
/* 101 */     this.rff2.mirror = true;
/* 102 */     setRotation(this.rff2, -0.4537856F, 0.0F, 0.0F);
/* 103 */     this.rff3 = new ModelRenderer(this, 0, 6);
/* 104 */     this.rff3.addBox(-0.5F, 1.0F, 4.0F, 0, 1, 3);
/* 105 */     this.rff3.setRotationPoint(-2.0F, 14.0F, 1.0F);
/* 106 */     this.rff3.setTextureSize(128, 128);
/* 107 */     this.rff3.mirror = true;
/* 108 */     setRotation(this.rff3, -1.047198F, 0.0F, 0.0F);
/* 109 */     this.rff1 = new ModelRenderer(this, 0, 6);
/* 110 */     this.rff1.addBox(-0.5F, 2.0F, 2.0F, 0, 1, 3);
/* 111 */     this.rff1.setRotationPoint(-2.0F, 14.0F, 1.0F);
/* 112 */     this.rff1.setTextureSize(128, 128);
/* 113 */     this.rff1.mirror = true;
/* 114 */     setRotation(this.rff1, -0.2792527F, 0.0F, 0.0F);
/* 115 */     this.tf4 = new ModelRenderer(this, 0, 3);
/* 116 */     this.tf4.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3);
/* 117 */     this.tf4.setRotationPoint(0.0F, 11.0F, 25.0F);
/* 118 */     this.tf4.setTextureSize(128, 128);
/* 119 */     this.tf4.mirror = true;
/* 120 */     setRotation(this.tf4, -0.5410521F, 0.0F, 0.0F);
/* 121 */     this.tf1 = new ModelRenderer(this, 0, 3);
/* 122 */     this.tf1.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3);
/* 123 */     this.tf1.setRotationPoint(0.0F, 11.0F, 19.0F);
/* 124 */     this.tf1.setTextureSize(128, 128);
/* 125 */     this.tf1.mirror = true;
/* 126 */     setRotation(this.tf1, -0.5410521F, 0.0F, 0.0F);
/* 127 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 128 */     this.Shape1.addBox(-2.0F, 0.0F, 0.0F, 4, 7, 11);
/* 129 */     this.Shape1.setRotationPoint(0.0F, 10.0F, 0.0F);
/* 130 */     this.Shape1.setTextureSize(128, 128);
/* 131 */     this.Shape1.mirror = true;
/* 132 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 133 */     this.neck = new ModelRenderer(this, 0, 19);
/* 134 */     this.neck.addBox(-1.0F, -7.0F, -2.0F, 2, 8, 3);
/* 135 */     this.neck.setRotationPoint(0.0F, 12.0F, 2.0F);
/* 136 */     this.neck.setTextureSize(128, 128);
/* 137 */     this.neck.mirror = true;
/* 138 */     setRotation(this.neck, 1.082104F, 0.0F, 0.0F);
/* 139 */     this.head1 = new ModelRenderer(this, 0, 49);
/* 140 */     this.head1.addBox(-2.0F, 0.0F, -7.0F, 3, 4, 7);
/* 141 */     this.head1.setRotationPoint(0.5F, 7.0F, -1.0F);
/* 142 */     this.head1.setTextureSize(128, 128);
/* 143 */     this.head1.mirror = true;
/* 144 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/* 145 */     this.lf1 = new ModelRenderer(this, 0, 31);
/* 146 */     this.lf1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2);
/* 147 */     this.lf1.setRotationPoint(2.0F, 14.0F, 1.0F);
/* 148 */     this.lf1.setTextureSize(128, 128);
/* 149 */     this.lf1.mirror = true;
/* 150 */     setRotation(this.lf1, 0.2792527F, 0.0F, 0.0F);
/* 151 */     this.lf2 = new ModelRenderer(this, 16, 19);
/* 152 */     this.lf2.addBox(0.0F, 1.0F, 2.0F, 1, 4, 1);
/* 153 */     this.lf2.setRotationPoint(2.0F, 14.0F, 1.0F);
/* 154 */     this.lf2.setTextureSize(128, 128);
/* 155 */     this.lf2.mirror = true;
/* 156 */     setRotation(this.lf2, -0.4363323F, 0.0F, 0.0F);
/* 157 */     this.head2 = new ModelRenderer(this, 20, 0);
/* 158 */     this.head2.addBox(-1.0F, 0.0F, -10.0F, 2, 4, 4);
/* 159 */     this.head2.setRotationPoint(0.0F, 7.0F, -1.0F);
/* 160 */     this.head2.setTextureSize(128, 128);
/* 161 */     this.head2.mirror = true;
/* 162 */     setRotation(this.head2, 0.0F, 0.0F, 0.0F);
/* 163 */     this.tail1 = new ModelRenderer(this, 0, 38);
/* 164 */     this.tail1.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 4);
/* 165 */     this.tail1.setRotationPoint(0.0F, 10.0F, 11.0F);
/* 166 */     this.tail1.setTextureSize(128, 128);
/* 167 */     this.tail1.mirror = true;
/* 168 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/* 169 */     this.tail2 = new ModelRenderer(this, 26, 11);
/* 170 */     this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
/* 171 */     this.tail2.setRotationPoint(-0.5F, 10.0F, 15.0F);
/* 172 */     this.tail2.setTextureSize(128, 128);
/* 173 */     this.tail2.mirror = true;
/* 174 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/* 175 */     this.bl1 = new ModelRenderer(this, 22, 24);
/* 176 */     this.bl1.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 4);
/* 177 */     this.bl1.setRotationPoint(2.0F, 13.0F, 6.0F);
/* 178 */     this.bl1.setTextureSize(128, 128);
/* 179 */     this.bl1.mirror = true;
/* 180 */     setRotation(this.bl1, 0.0F, 0.0F, 0.0F);
/* 181 */     this.br1 = new ModelRenderer(this, 36, 0);
/* 182 */     this.br1.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 4);
/* 183 */     this.br1.setRotationPoint(-2.0F, 13.0F, 6.0F);
/* 184 */     this.br1.setTextureSize(128, 128);
/* 185 */     this.br1.mirror = true;
/* 186 */     setRotation(this.br1, 0.0F, 0.0F, 0.0F);
/* 187 */     this.bl2 = new ModelRenderer(this, 12, 26);
/* 188 */     this.bl2.addBox(-1.0F, 5.0F, -3.0F, 2, 5, 2);
/* 189 */     this.bl2.setRotationPoint(2.0F, 13.0F, 6.0F);
/* 190 */     this.bl2.setTextureSize(128, 128);
/* 191 */     this.bl2.mirror = true;
/* 192 */     setRotation(this.bl2, 0.4886922F, 0.0F, 0.0F);
/* 193 */     this.br2 = new ModelRenderer(this, 13, 36);
/* 194 */     this.br2.addBox(-1.0F, 5.0F, -3.0F, 2, 5, 2);
/* 195 */     this.br2.setRotationPoint(-2.0F, 13.0F, 6.0F);
/* 196 */     this.br2.setTextureSize(128, 128);
/* 197 */     this.br2.mirror = true;
/* 198 */     setRotation(this.br2, 0.4886922F, 0.0F, 0.0F);
/* 199 */     this.bl3 = new ModelRenderer(this, 28, 39);
/* 200 */     this.bl3.addBox(-1.0F, 9.0F, -1.0F, 2, 2, 4);
/* 201 */     this.bl3.setRotationPoint(2.0F, 13.0F, 6.0F);
/* 202 */     this.bl3.setTextureSize(128, 128);
/* 203 */     this.bl3.mirror = true;
/* 204 */     setRotation(this.bl3, 0.0F, 0.0F, 0.0F);
/* 205 */     this.br3 = new ModelRenderer(this, 18, 45);
/* 206 */     this.br3.addBox(-1.0F, 9.0F, -1.0F, 2, 2, 4);
/* 207 */     this.br3.setRotationPoint(-2.0F, 13.0F, 6.0F);
/* 208 */     this.br3.setTextureSize(128, 128);
/* 209 */     this.br3.mirror = true;
/* 210 */     setRotation(this.br3, 0.0F, 0.0F, 0.0F);
/* 211 */     this.rf1 = new ModelRenderer(this, 35, 31);
/* 212 */     this.rf1.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 2);
/* 213 */     this.rf1.setRotationPoint(-2.0F, 14.0F, 1.0F);
/* 214 */     this.rf1.setTextureSize(128, 128);
/* 215 */     this.rf1.mirror = true;
/* 216 */     setRotation(this.rf1, 0.2792527F, 0.0F, 0.0F);
/* 217 */     this.rf2 = new ModelRenderer(this, 11, 19);
/* 218 */     this.rf2.addBox(-1.0F, 1.0F, 2.0F, 1, 4, 1);
/* 219 */     this.rf2.setRotationPoint(-2.0F, 14.0F, 1.0F);
/* 220 */     this.rf2.setTextureSize(128, 128);
/* 221 */     this.rf2.mirror = true;
/* 222 */     setRotation(this.rf2, -0.4363323F, 0.0F, 0.0F);
/* 223 */     this.tf2 = new ModelRenderer(this, 0, 3);
/* 224 */     this.tf2.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3);
/* 225 */     this.tf2.setRotationPoint(0.0F, 11.0F, 21.0F);
/* 226 */     this.tf2.setTextureSize(128, 128);
/* 227 */     this.tf2.mirror = true;
/* 228 */     setRotation(this.tf2, -0.5410521F, 0.0F, 0.0F);
/* 229 */     this.tf3 = new ModelRenderer(this, 0, 3);
/* 230 */     this.tf3.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3);
/* 231 */     this.tf3.setRotationPoint(0.0F, 11.0F, 23.0F);
/* 232 */     this.tf3.setTextureSize(128, 128);
/* 233 */     this.tf3.mirror = true;
/* 234 */     setRotation(this.tf3, -0.5410521F, 0.0F, 0.0F);
/* 235 */     this.bl4 = new ModelRenderer(this, 31, 10);
/* 236 */     this.bl4.addBox(-1.0F, 6.0F, -5.0F, 1, 3, 1);
/* 237 */     this.bl4.setRotationPoint(2.0F, 13.0F, 6.0F);
/* 238 */     this.bl4.setTextureSize(128, 128);
/* 239 */     this.bl4.mirror = true;
/* 240 */     setRotation(this.bl4, 0.6283185F, 0.0F, 0.0F);
/* 241 */     this.br4 = new ModelRenderer(this, 31, 15);
/* 242 */     this.br4.addBox(0.0F, 6.0F, -5.0F, 1, 3, 1);
/* 243 */     this.br4.setRotationPoint(-2.0F, 13.0F, 6.0F);
/* 244 */     this.br4.setTextureSize(128, 128);
/* 245 */     this.br4.mirror = true;
/* 246 */     setRotation(this.br4, 0.6283185F, 0.0F, 0.0F);
/* 247 */     this.Hat1 = new ModelRenderer(this, 50, 0);
/* 248 */     this.Hat1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5);
/* 249 */     this.Hat1.setRotationPoint(-2.0F, 6.0F, -6.0F);
/* 250 */     this.Hat1.setTextureSize(128, 128);
/* 251 */     this.Hat1.mirror = true;
/* 252 */     setRotation(this.Hat1, 0.0F, 0.0F, 0.0F);
/* 253 */     this.Hat2 = new ModelRenderer(this, 50, 0);
/* 254 */     this.Hat2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3);
/* 255 */     this.Hat2.setRotationPoint(-1.5F, 4.0F, -4.0F);
/* 256 */     this.Hat2.setTextureSize(128, 128);
/* 257 */     this.Hat2.mirror = true;
/* 258 */     setRotation(this.Hat2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 265 */     VelocityRaptor c = (VelocityRaptor)entity;
/* 266 */     float hf = 0.0F;
/* 267 */     float newangle = 0.0F;
/*     */     
/* 269 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 270 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 275 */     if (f1 > 0.1D) {
/* 276 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 278 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 281 */     this.bl1.rotateAngleX = newangle;
/* 282 */     this.bl2.rotateAngleX = newangle + 0.488F;
/* 283 */     this.bl3.rotateAngleX = newangle;
/* 284 */     this.bl4.rotateAngleX = newangle + 0.628F;
/*     */     
/* 286 */     this.br1.rotateAngleX = -newangle;
/* 287 */     this.br2.rotateAngleX = -newangle + 0.488F;
/* 288 */     this.br3.rotateAngleX = -newangle;
/* 289 */     this.br4.rotateAngleX = -newangle + 0.628F;
/*     */ 
/*     */     
/* 292 */     hf = c.getVHealth() / c.getMaxHealth();
/* 293 */     newangle = MathHelper.cos(f2 * 1.25F * this.wingspeed * hf) * 3.1415927F * 0.1F * hf;
/* 294 */     this.hf1.rotateAngleY = newangle;
/* 295 */     this.hf2.rotateAngleY = -newangle;
/* 296 */     this.hf3.rotateAngleY = newangle;
/* 297 */     this.hf4.rotateAngleY = -newangle;
/*     */ 
/*     */     
/* 300 */     newangle = MathHelper.cos(f2 * 0.3F) * 3.1415927F * 0.05F;
/* 301 */     this.lf1.rotateAngleX = newangle + 0.279F;
/* 302 */     this.lf2.rotateAngleX = newangle - 0.436F;
/* 303 */     this.lff1.rotateAngleX = newangle - 0.279F;
/* 304 */     this.lff2.rotateAngleX = newangle - 0.453F;
/* 305 */     this.lff3.rotateAngleX = newangle - 1.047F;
/*     */     
/* 307 */     this.rf1.rotateAngleX = -newangle + 0.279F;
/* 308 */     this.rf2.rotateAngleX = -newangle - 0.436F;
/* 309 */     this.rff1.rotateAngleX = -newangle - 0.279F;
/* 310 */     this.rff2.rotateAngleX = -newangle - 0.453F;
/* 311 */     this.rff3.rotateAngleX = -newangle - 1.047F;
/*     */ 
/*     */     
/* 314 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F;
/* 315 */     this.lff1.rotateAngleY = newangle;
/* 316 */     this.lff2.rotateAngleY = -newangle;
/* 317 */     this.lff3.rotateAngleY = newangle;
/*     */     
/* 319 */     this.rff1.rotateAngleY = -newangle;
/* 320 */     this.rff2.rotateAngleY = newangle;
/* 321 */     this.rff3.rotateAngleY = -newangle;
/*     */ 
/*     */     
/* 324 */     if (c.isSitting()) {
/* 325 */       newangle = 0.0F;
/*     */     } else {
/* 327 */       newangle = MathHelper.cos(f2 * 1.4F * this.wingspeed * hf) * 3.1415927F * 0.25F * hf;
/*     */     } 
/* 329 */     this.tf1.rotateAngleZ = newangle;
/* 330 */     this.tf2.rotateAngleZ = -newangle;
/* 331 */     this.tf3.rotateAngleZ = newangle;
/* 332 */     this.tf4.rotateAngleZ = -newangle;
/*     */ 
/*     */ 
/*     */     
/* 336 */     this.hf3.render(f5);
/* 337 */     this.hf4.render(f5);
/* 338 */     this.hf2.render(f5);
/* 339 */     this.hf1.render(f5);
/*     */     
/* 341 */     this.tf1.render(f5);
/* 342 */     this.tf2.render(f5);
/* 343 */     this.tf3.render(f5);
/* 344 */     this.tf4.render(f5);
/*     */     
/* 346 */     this.lf1.render(f5);
/* 347 */     this.lf2.render(f5);
/* 348 */     this.lff2.render(f5);
/* 349 */     this.lff1.render(f5);
/* 350 */     this.lff3.render(f5);
/*     */     
/* 352 */     this.rf1.render(f5);
/* 353 */     this.rf2.render(f5);
/* 354 */     this.rff2.render(f5);
/* 355 */     this.rff3.render(f5);
/* 356 */     this.rff1.render(f5);
/*     */     
/* 358 */     this.bl1.render(f5);
/* 359 */     this.bl2.render(f5);
/* 360 */     this.bl3.render(f5);
/* 361 */     this.bl4.render(f5);
/*     */     
/* 363 */     this.br1.render(f5);
/* 364 */     this.br2.render(f5);
/* 365 */     this.br3.render(f5);
/* 366 */     this.br4.render(f5);
/*     */     
/* 368 */     this.Shape1.render(f5);
/* 369 */     this.neck.render(f5);
/* 370 */     this.head1.render(f5);
/* 371 */     this.head2.render(f5);
/* 372 */     this.tail1.render(f5);
/* 373 */     this.tail2.render(f5);
/*     */   }
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
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 388 */     model.rotateAngleX = x;
/* 389 */     model.rotateAngleY = y;
/* 390 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 395 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelVelocityRaptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */