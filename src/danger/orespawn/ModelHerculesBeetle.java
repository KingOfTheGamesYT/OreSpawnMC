/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelHerculesBeetle
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body1;
/*     */   
/*     */   ModelRenderer body2;
/*     */   
/*     */   ModelRenderer head1;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer head3;
/*     */   ModelRenderer head4;
/*     */   ModelRenderer head5;
/*     */   ModelRenderer head6;
/*     */   ModelRenderer head8;
/*     */   ModelRenderer jaw1;
/*     */   ModelRenderer jaw2;
/*     */   ModelRenderer jaw3;
/*     */   ModelRenderer jaw4;
/*     */   ModelRenderer head7;
/*     */   ModelRenderer lfleg1;
/*     */   ModelRenderer lfleg2;
/*     */   ModelRenderer lfleg3;
/*     */   ModelRenderer lmleg1;
/*     */   ModelRenderer lmleg2;
/*     */   ModelRenderer lmleg3;
/*     */   ModelRenderer lrleg1;
/*     */   ModelRenderer lrleg2;
/*     */   ModelRenderer lrleg3;
/*     */   ModelRenderer jaw5;
/*     */   ModelRenderer jaw6;
/*     */   ModelRenderer jaw7;
/*     */   ModelRenderer jaw8;
/*     */   ModelRenderer rfleg1;
/*     */   ModelRenderer rfleg2;
/*     */   ModelRenderer rfleg3;
/*     */   ModelRenderer rmleg1;
/*     */   ModelRenderer rmleg2;
/*     */   ModelRenderer rmleg3;
/*     */   ModelRenderer rrleg1;
/*     */   ModelRenderer rrleg2;
/*     */   ModelRenderer rrleg3;
/*     */   ModelRenderer jaw9;
/*     */   
/*     */   public ModelHerculesBeetle(float f1) {
/*  53 */     this.wingspeed = f1;
/*     */     
/*  55 */     this.textureWidth = 256;
/*  56 */     this.textureHeight = 256;
/*     */ 
/*     */     
/*  59 */     this.body1 = new ModelRenderer(this, 0, 30);
/*  60 */     this.body1.addBox(-8.0F, 0.0F, 0.0F, 16, 16, 23);
/*  61 */     this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  62 */     this.body1.setTextureSize(256, 256);
/*  63 */     this.body1.mirror = true;
/*  64 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/*  65 */     this.body2 = new ModelRenderer(this, 80, 41);
/*  66 */     this.body2.addBox(-6.0F, 0.0F, 0.0F, 12, 12, 4);
/*  67 */     this.body2.setRotationPoint(0.0F, 3.0F, 23.0F);
/*  68 */     this.body2.setTextureSize(256, 256);
/*  69 */     this.body2.mirror = true;
/*  70 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  71 */     this.head1 = new ModelRenderer(this, 0, 71);
/*  72 */     this.head1.addBox(-9.0F, 0.0F, 0.0F, 18, 16, 12);
/*  73 */     this.head1.setRotationPoint(0.0F, -1.0F, -10.0F);
/*  74 */     this.head1.setTextureSize(256, 256);
/*  75 */     this.head1.mirror = true;
/*  76 */     setRotation(this.head1, -0.122173F, 0.0F, 0.0F);
/*  77 */     this.head2 = new ModelRenderer(this, 0, 100);
/*  78 */     this.head2.addBox(-7.0F, 0.0F, 0.0F, 14, 10, 6);
/*  79 */     this.head2.setRotationPoint(0.0F, -2.0F, -16.0F);
/*  80 */     this.head2.setTextureSize(256, 256);
/*  81 */     this.head2.mirror = true;
/*  82 */     setRotation(this.head2, -0.122173F, 0.0F, 0.0F);
/*  83 */     this.head3 = new ModelRenderer(this, 0, 117);
/*  84 */     this.head3.addBox(-5.0F, 0.0F, 0.0F, 10, 6, 9);
/*  85 */     this.head3.setRotationPoint(0.0F, -3.0F, -25.0F);
/*  86 */     this.head3.setTextureSize(256, 256);
/*  87 */     this.head3.mirror = true;
/*  88 */     setRotation(this.head3, -0.122173F, 0.0F, 0.0F);
/*  89 */     this.head4 = new ModelRenderer(this, 0, 133);
/*  90 */     this.head4.addBox(-4.0F, 0.0F, 0.0F, 8, 4, 12);
/*  91 */     this.head4.setRotationPoint(0.0F, -4.0F, -37.0F);
/*  92 */     this.head4.setTextureSize(256, 256);
/*  93 */     this.head4.mirror = true;
/*  94 */     setRotation(this.head4, -0.122173F, 0.0F, 0.0F);
/*  95 */     this.head5 = new ModelRenderer(this, 0, 150);
/*  96 */     this.head5.addBox(-3.0F, 0.0F, 0.0F, 6, 3, 21);
/*  97 */     this.head5.setRotationPoint(0.0F, -4.0F, -58.0F);
/*  98 */     this.head5.setTextureSize(256, 256);
/*  99 */     this.head5.mirror = true;
/* 100 */     setRotation(this.head5, 0.0F, 0.0F, 0.0F);
/* 101 */     this.head6 = new ModelRenderer(this, 0, 175);
/* 102 */     this.head6.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 14);
/* 103 */     this.head6.setRotationPoint(0.0F, -2.0F, -72.0F);
/* 104 */     this.head6.setTextureSize(256, 256);
/* 105 */     this.head6.mirror = true;
/* 106 */     setRotation(this.head6, 0.122173F, 0.0F, 0.0F);
/* 107 */     this.head8 = new ModelRenderer(this, 6, 193);
/* 108 */     this.head8.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 109 */     this.head8.setRotationPoint(0.0F, -2.0F, -46.0F);
/* 110 */     this.head8.setTextureSize(256, 256);
/* 111 */     this.head8.mirror = true;
/* 112 */     setRotation(this.head8, -0.2094395F, 0.0F, 0.0F);
/* 113 */     this.jaw1 = new ModelRenderer(this, 114, 0);
/* 114 */     this.jaw1.addBox(-3.0F, -3.0F, -4.0F, 6, 7, 5);
/* 115 */     this.jaw1.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 116 */     this.jaw1.setTextureSize(256, 256);
/* 117 */     this.jaw1.mirror = true;
/* 118 */     setRotation(this.jaw1, 0.122173F, 0.0F, 0.0F);
/* 119 */     this.jaw2 = new ModelRenderer(this, 115, 14);
/* 120 */     this.jaw2.addBox(-2.5F, -3.0F, -27.0F, 5, 5, 23);
/* 121 */     this.jaw2.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 122 */     this.jaw2.setTextureSize(256, 256);
/* 123 */     this.jaw2.mirror = true;
/* 124 */     setRotation(this.jaw2, 0.122173F, 0.0F, 0.0F);
/* 125 */     this.jaw3 = new ModelRenderer(this, 115, 43);
/* 126 */     this.jaw3.addBox(-1.5F, 0.0F, -44.0F, 3, 5, 18);
/* 127 */     this.jaw3.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 128 */     this.jaw3.setTextureSize(256, 256);
/* 129 */     this.jaw3.mirror = true;
/* 130 */     setRotation(this.jaw3, 0.0F, 0.0F, 0.0F);
/* 131 */     this.jaw4 = new ModelRenderer(this, 115, 70);
/* 132 */     this.jaw4.addBox(-0.5F, -2.0F, -45.0F, 1, 5, 1);
/* 133 */     this.jaw4.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 134 */     this.jaw4.setTextureSize(256, 256);
/* 135 */     this.jaw4.mirror = true;
/* 136 */     setRotation(this.jaw4, 0.0F, 0.0F, 0.0F);
/* 137 */     this.head7 = new ModelRenderer(this, 0, 193);
/* 138 */     this.head7.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1);
/* 139 */     this.head7.setRotationPoint(0.0F, -2.0F, -73.0F);
/* 140 */     this.head7.setTextureSize(256, 256);
/* 141 */     this.head7.mirror = true;
/* 142 */     setRotation(this.head7, 0.122173F, 0.0F, 0.0F);
/* 143 */     this.lfleg1 = new ModelRenderer(this, 60, 0);
/* 144 */     this.lfleg1.addBox(0.0F, 0.0F, -0.5F, 10, 3, 3);
/* 145 */     this.lfleg1.setRotationPoint(6.0F, 15.0F, -5.0F);
/* 146 */     this.lfleg1.setTextureSize(256, 256);
/* 147 */     this.lfleg1.mirror = true;
/* 148 */     setRotation(this.lfleg1, 0.0F, 0.3490659F, 0.0872665F);
/* 149 */     this.lfleg2 = new ModelRenderer(this, 60, 8);
/* 150 */     this.lfleg2.addBox(10.0F, -1.0F, 0.0F, 11, 2, 2);
/* 151 */     this.lfleg2.setRotationPoint(6.0F, 15.0F, -5.0F);
/* 152 */     this.lfleg2.setTextureSize(256, 256);
/* 153 */     this.lfleg2.mirror = true;
/* 154 */     setRotation(this.lfleg2, 0.0F, 0.3490659F, 0.2617994F);
/* 155 */     this.lfleg3 = new ModelRenderer(this, 60, 14);
/* 156 */     this.lfleg3.addBox(21.0F, -2.0F, 0.5F, 10, 1, 1);
/* 157 */     this.lfleg3.setRotationPoint(6.0F, 15.0F, -5.0F);
/* 158 */     this.lfleg3.setTextureSize(256, 256);
/* 159 */     this.lfleg3.mirror = true;
/* 160 */     setRotation(this.lfleg3, 0.0F, 0.3490659F, 0.3490659F);
/* 161 */     this.lmleg1 = new ModelRenderer(this, 60, 0);
/* 162 */     this.lmleg1.addBox(0.0F, 0.0F, -0.5F, 10, 3, 3);
/* 163 */     this.lmleg1.setRotationPoint(6.0F, 15.0F, 0.0F);
/* 164 */     this.lmleg1.setTextureSize(256, 256);
/* 165 */     this.lmleg1.mirror = true;
/* 166 */     setRotation(this.lmleg1, 0.0F, 0.0F, 0.0872665F);
/* 167 */     this.lmleg2 = new ModelRenderer(this, 60, 8);
/* 168 */     this.lmleg2.addBox(10.0F, -1.0F, 0.0F, 11, 2, 2);
/* 169 */     this.lmleg2.setRotationPoint(6.0F, 15.0F, 0.0F);
/* 170 */     this.lmleg2.setTextureSize(256, 256);
/* 171 */     this.lmleg2.mirror = true;
/* 172 */     setRotation(this.lmleg2, 0.0F, 0.0F, 0.2617994F);
/* 173 */     this.lmleg3 = new ModelRenderer(this, 60, 14);
/* 174 */     this.lmleg3.addBox(21.0F, -2.0F, 0.5F, 10, 1, 1);
/* 175 */     this.lmleg3.setRotationPoint(6.0F, 15.0F, 0.0F);
/* 176 */     this.lmleg3.setTextureSize(256, 256);
/* 177 */     this.lmleg3.mirror = true;
/* 178 */     setRotation(this.lmleg3, 0.0F, 0.0F, 0.3490659F);
/* 179 */     this.lrleg1 = new ModelRenderer(this, 60, 0);
/* 180 */     this.lrleg1.addBox(0.0F, 0.0F, -0.5F, 10, 3, 3);
/* 181 */     this.lrleg1.setRotationPoint(6.0F, 15.0F, 5.0F);
/* 182 */     this.lrleg1.setTextureSize(256, 256);
/* 183 */     this.lrleg1.mirror = true;
/* 184 */     setRotation(this.lrleg1, 0.0F, -0.3490659F, 0.0872665F);
/* 185 */     this.lrleg2 = new ModelRenderer(this, 60, 8);
/* 186 */     this.lrleg2.addBox(10.0F, -1.0F, 0.0F, 11, 2, 2);
/* 187 */     this.lrleg2.setRotationPoint(6.0F, 15.0F, 5.0F);
/* 188 */     this.lrleg2.setTextureSize(256, 256);
/* 189 */     this.lrleg2.mirror = true;
/* 190 */     setRotation(this.lrleg2, 0.0F, -0.3490659F, 0.2617994F);
/* 191 */     this.lrleg3 = new ModelRenderer(this, 60, 14);
/* 192 */     this.lrleg3.addBox(21.0F, -2.0F, 0.5F, 10, 1, 1);
/* 193 */     this.lrleg3.setRotationPoint(6.0F, 15.0F, 5.0F);
/* 194 */     this.lrleg3.setTextureSize(256, 256);
/* 195 */     this.lrleg3.mirror = true;
/* 196 */     setRotation(this.lrleg3, 0.0F, -0.3490659F, 0.3490659F);
/* 197 */     this.jaw5 = new ModelRenderer(this, 115, 78);
/* 198 */     this.jaw5.addBox(2.0F, -2.0F, -9.0F, 2, 3, 3);
/* 199 */     this.jaw5.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 200 */     this.jaw5.setTextureSize(256, 256);
/* 201 */     this.jaw5.mirror = true;
/* 202 */     setRotation(this.jaw5, 0.122173F, 0.0F, 0.0F);
/* 203 */     this.jaw6 = new ModelRenderer(this, 127, 78);
/* 204 */     this.jaw6.addBox(-4.0F, -2.0F, -9.0F, 2, 3, 3);
/* 205 */     this.jaw6.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 206 */     this.jaw6.setTextureSize(256, 256);
/* 207 */     this.jaw6.mirror = true;
/* 208 */     setRotation(this.jaw6, 0.122173F, 0.0F, 0.0F);
/* 209 */     this.jaw7 = new ModelRenderer(this, 115, 86);
/* 210 */     this.jaw7.addBox(5.0F, 1.0F, -6.0F, 9, 1, 1);
/* 211 */     this.jaw7.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 212 */     this.jaw7.setTextureSize(256, 256);
/* 213 */     this.jaw7.mirror = true;
/* 214 */     setRotation(this.jaw7, 0.0F, 0.5585054F, 0.2268928F);
/* 215 */     this.jaw8 = new ModelRenderer(this, 115, 89);
/* 216 */     this.jaw8.addBox(-14.0F, 1.0F, -6.0F, 9, 1, 1);
/* 217 */     this.jaw8.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 218 */     this.jaw8.setTextureSize(256, 256);
/* 219 */     this.jaw8.mirror = true;
/* 220 */     setRotation(this.jaw8, 0.0F, -0.5585054F, -0.2268928F);
/* 221 */     this.rfleg1 = new ModelRenderer(this, 30, 0);
/* 222 */     this.rfleg1.addBox(-10.0F, 0.0F, -0.5F, 10, 3, 3);
/* 223 */     this.rfleg1.setRotationPoint(-6.0F, 15.0F, -5.0F);
/* 224 */     this.rfleg1.setTextureSize(256, 256);
/* 225 */     this.rfleg1.mirror = true;
/* 226 */     setRotation(this.rfleg1, 0.0F, -0.3490659F, -0.0872665F);
/* 227 */     this.rfleg2 = new ModelRenderer(this, 30, 8);
/* 228 */     this.rfleg2.addBox(-21.0F, -1.0F, 0.0F, 11, 2, 2);
/* 229 */     this.rfleg2.setRotationPoint(-6.0F, 15.0F, -5.0F);
/* 230 */     this.rfleg2.setTextureSize(256, 256);
/* 231 */     this.rfleg2.mirror = true;
/* 232 */     setRotation(this.rfleg2, 0.0F, -0.3490659F, -0.2617994F);
/* 233 */     this.rfleg3 = new ModelRenderer(this, 30, 14);
/* 234 */     this.rfleg3.addBox(-31.0F, -2.0F, 0.5F, 10, 1, 1);
/* 235 */     this.rfleg3.setRotationPoint(-6.0F, 15.0F, -5.0F);
/* 236 */     this.rfleg3.setTextureSize(256, 256);
/* 237 */     this.rfleg3.mirror = true;
/* 238 */     setRotation(this.rfleg3, 0.0F, -0.3490659F, -0.3490659F);
/* 239 */     this.rmleg1 = new ModelRenderer(this, 30, 0);
/* 240 */     this.rmleg1.addBox(-10.0F, 0.0F, -0.5F, 10, 3, 3);
/* 241 */     this.rmleg1.setRotationPoint(-6.0F, 15.0F, 0.0F);
/* 242 */     this.rmleg1.setTextureSize(256, 256);
/* 243 */     this.rmleg1.mirror = true;
/* 244 */     setRotation(this.rmleg1, 0.0F, 0.0F, -0.0872665F);
/* 245 */     this.rmleg2 = new ModelRenderer(this, 30, 8);
/* 246 */     this.rmleg2.addBox(-21.0F, -1.0F, 0.0F, 11, 2, 2);
/* 247 */     this.rmleg2.setRotationPoint(-6.0F, 15.0F, 0.0F);
/* 248 */     this.rmleg2.setTextureSize(256, 256);
/* 249 */     this.rmleg2.mirror = true;
/* 250 */     setRotation(this.rmleg2, 0.0F, 0.0F, -0.2617994F);
/* 251 */     this.rmleg3 = new ModelRenderer(this, 30, 14);
/* 252 */     this.rmleg3.addBox(-31.0F, -2.0F, 0.5F, 10, 1, 1);
/* 253 */     this.rmleg3.setRotationPoint(-6.0F, 15.0F, 0.0F);
/* 254 */     this.rmleg3.setTextureSize(256, 256);
/* 255 */     this.rmleg3.mirror = true;
/* 256 */     setRotation(this.rmleg3, 0.0F, 0.0F, -0.3490659F);
/* 257 */     this.rrleg1 = new ModelRenderer(this, 30, 0);
/* 258 */     this.rrleg1.addBox(-10.0F, 0.0F, -0.5F, 10, 3, 3);
/* 259 */     this.rrleg1.setRotationPoint(-6.0F, 15.0F, 5.0F);
/* 260 */     this.rrleg1.setTextureSize(256, 256);
/* 261 */     this.rrleg1.mirror = true;
/* 262 */     setRotation(this.rrleg1, 0.0F, 0.3490659F, -0.0872665F);
/* 263 */     this.rrleg2 = new ModelRenderer(this, 30, 8);
/* 264 */     this.rrleg2.addBox(-21.0F, -1.0F, 0.0F, 11, 2, 2);
/* 265 */     this.rrleg2.setRotationPoint(-6.0F, 15.0F, 5.0F);
/* 266 */     this.rrleg2.setTextureSize(256, 256);
/* 267 */     this.rrleg2.mirror = true;
/* 268 */     setRotation(this.rrleg2, 0.0F, 0.3490659F, -0.2617994F);
/* 269 */     this.rrleg3 = new ModelRenderer(this, 30, 14);
/* 270 */     this.rrleg3.addBox(-31.0F, -2.0F, 0.5F, 10, 1, 1);
/* 271 */     this.rrleg3.setRotationPoint(-6.0F, 15.0F, 5.0F);
/* 272 */     this.rrleg3.setTextureSize(256, 256);
/* 273 */     this.rrleg3.mirror = true;
/* 274 */     setRotation(this.rrleg3, 0.0F, 0.3490659F, -0.3490659F);
/* 275 */     this.jaw9 = new ModelRenderer(this, 121, 70);
/* 276 */     this.jaw9.addBox(-0.5F, -12.0F, -25.0F, 1, 5, 1);
/* 277 */     this.jaw9.setRotationPoint(0.0F, 12.0F, -12.0F);
/* 278 */     this.jaw9.setTextureSize(256, 256);
/* 279 */     this.jaw9.mirror = true;
/* 280 */     setRotation(this.jaw9, 0.3141593F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 285 */     float newangle = 0.0F;
/* 286 */     HerculesBeetle b = (HerculesBeetle)entity;
/*     */     
/* 288 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 289 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 292 */     newangle = MathHelper.cos(f2 * this.wingspeed * 0.45F) * 3.1415927F * 0.12F * f1;
/* 293 */     this.lfleg1.rotateAngleY = 0.349F + newangle;
/* 294 */     this.lfleg2.rotateAngleY = this.lfleg1.rotateAngleY;
/* 295 */     this.lmleg1.rotateAngleY = -newangle;
/* 296 */     this.lmleg2.rotateAngleY = this.lmleg1.rotateAngleY;
/* 297 */     this.lrleg1.rotateAngleY = -0.349F + newangle;
/* 298 */     this.lrleg2.rotateAngleY = this.lrleg1.rotateAngleY;
/*     */     
/* 300 */     this.rfleg1.rotateAngleY = -0.349F + newangle;
/* 301 */     this.rfleg2.rotateAngleY = this.rfleg1.rotateAngleY;
/* 302 */     this.rmleg1.rotateAngleY = -newangle;
/* 303 */     this.rmleg2.rotateAngleY = this.rmleg1.rotateAngleY;
/* 304 */     this.rrleg1.rotateAngleY = 0.349F + newangle;
/* 305 */     this.rrleg2.rotateAngleY = this.rrleg1.rotateAngleY;
/*     */ 
/*     */     
/* 308 */     if (b.getAttacking() == 0) {
/* 309 */       newangle = MathHelper.cos(f2 * 0.051F * this.wingspeed) * 3.1415927F * 0.01F;
/*     */     } else {
/* 311 */       newangle = MathHelper.cos(f2 * 0.51F * this.wingspeed) * 3.1415927F * 0.07F;
/*     */     } 
/* 313 */     this.jaw1.rotateAngleX = 0.122F + newangle;
/* 314 */     this.jaw2.rotateAngleX = 0.122F + newangle;
/* 315 */     this.jaw3.rotateAngleX = 0.0F + newangle;
/* 316 */     this.jaw4.rotateAngleX = 0.0F + newangle;
/* 317 */     this.jaw5.rotateAngleX = 0.122F + newangle;
/* 318 */     this.jaw6.rotateAngleX = 0.122F + newangle;
/* 319 */     this.jaw7.rotateAngleX = 0.0F + newangle;
/* 320 */     this.jaw8.rotateAngleX = 0.0F + newangle;
/* 321 */     this.jaw9.rotateAngleX = 0.314F + newangle;
/*     */     
/* 323 */     this.body1.render(f5);
/* 324 */     this.body2.render(f5);
/* 325 */     this.head1.render(f5);
/* 326 */     this.head2.render(f5);
/* 327 */     this.head3.render(f5);
/* 328 */     this.head4.render(f5);
/* 329 */     this.head5.render(f5);
/* 330 */     this.head6.render(f5);
/* 331 */     this.head8.render(f5);
/* 332 */     this.jaw1.render(f5);
/* 333 */     this.jaw2.render(f5);
/* 334 */     this.jaw3.render(f5);
/* 335 */     this.jaw4.render(f5);
/* 336 */     this.head7.render(f5);
/* 337 */     this.lfleg1.render(f5);
/* 338 */     this.lfleg2.render(f5);
/* 339 */     this.lfleg3.render(f5);
/* 340 */     this.lmleg1.render(f5);
/* 341 */     this.lmleg2.render(f5);
/* 342 */     this.lmleg3.render(f5);
/* 343 */     this.lrleg1.render(f5);
/* 344 */     this.lrleg2.render(f5);
/* 345 */     this.lrleg3.render(f5);
/* 346 */     this.jaw5.render(f5);
/* 347 */     this.jaw6.render(f5);
/* 348 */     this.jaw7.render(f5);
/* 349 */     this.jaw8.render(f5);
/* 350 */     this.rfleg1.render(f5);
/* 351 */     this.rfleg2.render(f5);
/* 352 */     this.rfleg3.render(f5);
/* 353 */     this.rmleg1.render(f5);
/* 354 */     this.rmleg2.render(f5);
/* 355 */     this.rmleg3.render(f5);
/* 356 */     this.rrleg1.render(f5);
/* 357 */     this.rrleg2.render(f5);
/* 358 */     this.rrleg3.render(f5);
/* 359 */     this.jaw9.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 365 */     model.rotateAngleX = x;
/* 366 */     model.rotateAngleY = y;
/* 367 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 372 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelHerculesBeetle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */