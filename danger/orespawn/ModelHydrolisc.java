/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelHydrolisc
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer tail2;
/*     */   
/*     */   ModelRenderer tail3;
/*     */   
/*     */   ModelRenderer body2;
/*     */   ModelRenderer lb2;
/*     */   ModelRenderer lb1;
/*     */   ModelRenderer spine3;
/*     */   ModelRenderer spine4;
/*     */   ModelRenderer rb1;
/*     */   ModelRenderer rb2;
/*     */   ModelRenderer spine1;
/*     */   ModelRenderer spine2;
/*     */   ModelRenderer lb3;
/*     */   ModelRenderer rb3;
/*     */   ModelRenderer body1;
/*     */   ModelRenderer body0;
/*     */   ModelRenderer lf1;
/*     */   ModelRenderer rf1;
/*     */   ModelRenderer rb6;
/*     */   ModelRenderer rb4;
/*     */   ModelRenderer rb5;
/*     */   ModelRenderer lb6;
/*     */   ModelRenderer lb5;
/*     */   ModelRenderer lb4;
/*     */   ModelRenderer head3;
/*     */   ModelRenderer feather3;
/*     */   ModelRenderer feather1;
/*     */   ModelRenderer feather2;
/*     */   ModelRenderer head1;
/*     */   ModelRenderer rf2;
/*     */   ModelRenderer rf3;
/*     */   ModelRenderer rf4;
/*     */   ModelRenderer rf5;
/*     */   ModelRenderer rf6;
/*     */   ModelRenderer lf2;
/*     */   ModelRenderer lf3;
/*     */   ModelRenderer lf4;
/*     */   ModelRenderer lf5;
/*     */   ModelRenderer lf6;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer tail1;
/*     */   
/*     */   public ModelHydrolisc(float f1) {
/*  57 */     this.wingspeed = f1;
/*     */     
/*  59 */     this.textureWidth = 64;
/*  60 */     this.textureHeight = 128;
/*     */     
/*  62 */     this.tail2 = new ModelRenderer(this, 29, 3);
/*  63 */     this.tail2.addBox(-1.0F, 0.0F, -0.8F, 2, 8, 2);
/*  64 */     this.tail2.setRotationPoint(1.0F, 20.0F, 13.53333F);
/*  65 */     this.tail2.setTextureSize(64, 128);
/*  66 */     this.tail2.mirror = true;
/*  67 */     setRotation(this.tail2, 1.392442F, 0.0F, 0.0F);
/*  68 */     this.tail3 = new ModelRenderer(this, 39, 0);
/*  69 */     this.tail3.addBox(-1.0F, -1.0F, -2.0F, 2, 8, 2);
/*  70 */     this.tail3.setRotationPoint(1.0F, 20.0F, 21.0F);
/*  71 */     this.tail3.setTextureSize(64, 128);
/*  72 */     this.tail3.mirror = true;
/*  73 */     setRotation(this.tail3, 1.72705F, 0.0F, 0.0F);
/*  74 */     this.body2 = new ModelRenderer(this, 0, 99);
/*  75 */     this.body2.addBox(-2.0F, 14.0F, 0.0F, 6, 4, 10);
/*  76 */     this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  77 */     this.body2.setTextureSize(64, 128);
/*  78 */     this.body2.mirror = true;
/*  79 */     setRotation(this.body2, -0.0523599F, 0.0F, 0.0F);
/*  80 */     this.lb2 = new ModelRenderer(this, 45, 13);
/*  81 */     this.lb2.addBox(0.0F, 0.0F, 3.0F, 3, 2, 5);
/*  82 */     this.lb2.setRotationPoint(5.0F, 15.0F, 0.0F);
/*  83 */     this.lb2.setTextureSize(64, 128);
/*  84 */     this.lb2.mirror = true;
/*  85 */     setRotation(this.lb2, -0.4886922F, 0.0F, 0.0F);
/*  86 */     this.lb1 = new ModelRenderer(this, 46, 22);
/*  87 */     this.lb1.addBox(-1.0F, 0.0F, 0.0F, 4, 3, 3);
/*  88 */     this.lb1.setRotationPoint(5.0F, 15.0F, 0.0F);
/*  89 */     this.lb1.setTextureSize(64, 128);
/*  90 */     this.lb1.mirror = true;
/*  91 */     setRotation(this.lb1, 0.0F, 0.0F, 0.0F);
/*  92 */     this.spine3 = new ModelRenderer(this, 11, 31);
/*  93 */     this.spine3.addBox(-1.0F, -5.0F, 0.0F, 2, 6, 2);
/*  94 */     this.spine3.setRotationPoint(1.0F, 14.0F, 6.0F);
/*  95 */     this.spine3.setTextureSize(64, 128);
/*  96 */     this.spine3.mirror = true;
/*  97 */     setRotation(this.spine3, -1.117011F, 0.0F, 0.0F);
/*  98 */     this.spine4 = new ModelRenderer(this, 0, 30);
/*  99 */     this.spine4.addBox(-1.0F, -10.5F, -1.0F, 2, 6, 2);
/* 100 */     this.spine4.setRotationPoint(1.0F, 14.0F, 6.0F);
/* 101 */     this.spine4.setTextureSize(64, 128);
/* 102 */     this.spine4.mirror = true;
/* 103 */     setRotation(this.spine4, -1.343904F, 0.0F, 0.0F);
/* 104 */     this.rb1 = new ModelRenderer(this, 46, 22);
/* 105 */     this.rb1.addBox(-4.0F, 0.0F, 0.0F, 4, 3, 3);
/* 106 */     this.rb1.setRotationPoint(-2.0F, 15.0F, 0.0F);
/* 107 */     this.rb1.setTextureSize(64, 128);
/* 108 */     this.rb1.mirror = true;
/* 109 */     setRotation(this.rb1, 0.0F, 0.0F, 0.0F);
/* 110 */     this.rb2 = new ModelRenderer(this, 45, 13);
/* 111 */     this.rb2.addBox(-4.0F, 0.0F, 2.0F, 3, 2, 5);
/* 112 */     this.rb2.setRotationPoint(-2.0F, 15.0F, 0.0F);
/* 113 */     this.rb2.setTextureSize(64, 128);
/* 114 */     this.rb2.mirror = true;
/* 115 */     setRotation(this.rb2, -0.4886922F, 0.0F, 0.0F);
/* 116 */     this.spine1 = new ModelRenderer(this, 33, 19);
/* 117 */     this.spine1.addBox(-1.0F, -5.0F, 0.0F, 2, 6, 2);
/* 118 */     this.spine1.setRotationPoint(1.0F, 14.0F, 0.0F);
/* 119 */     this.spine1.setTextureSize(64, 128);
/* 120 */     this.spine1.mirror = true;
/* 121 */     setRotation(this.spine1, -0.8552113F, 0.0F, 0.0F);
/* 122 */     this.spine2 = new ModelRenderer(this, 21, 19);
/* 123 */     this.spine2.addBox(-1.0F, -10.5F, -1.5F, 2, 6, 2);
/* 124 */     this.spine2.setRotationPoint(1.0F, 14.0F, 0.0F);
/* 125 */     this.spine2.setTextureSize(64, 128);
/* 126 */     this.spine2.mirror = true;
/* 127 */     setRotation(this.spine2, -1.169371F, 0.0F, 0.0F);
/* 128 */     this.lb3 = new ModelRenderer(this, 0, 58);
/* 129 */     this.lb3.addBox(0.0F, -8.0F, -2.0F, 3, 2, 6);
/* 130 */     this.lb3.setRotationPoint(5.0F, 15.0F, 0.0F);
/* 131 */     this.lb3.setTextureSize(64, 128);
/* 132 */     this.lb3.mirror = true;
/* 133 */     setRotation(this.lb3, -2.347623F, 0.0F, 0.0F);
/* 134 */     this.rb3 = new ModelRenderer(this, 0, 58);
/* 135 */     this.rb3.addBox(-4.0F, -8.0F, -2.0F, 3, 2, 6);
/* 136 */     this.rb3.setRotationPoint(-2.0F, 15.0F, 0.0F);
/* 137 */     this.rb3.setTextureSize(64, 128);
/* 138 */     this.rb3.mirror = true;
/* 139 */     setRotation(this.rb3, -2.347623F, 0.0F, 0.0F);
/* 140 */     this.body1 = new ModelRenderer(this, 0, 79);
/* 141 */     this.body1.addBox(-2.0F, 16.0F, -7.0F, 4, 2, 5);
/* 142 */     this.body1.setRotationPoint(1.0F, -1.0F, 2.0F);
/* 143 */     this.body1.setTextureSize(64, 128);
/* 144 */     this.body1.mirror = true;
/* 145 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/* 146 */     this.body0 = new ModelRenderer(this, 0, 0);
/* 147 */     this.body0.addBox(-1.0F, 14.0F, -13.0F, 4, 3, 10);
/* 148 */     this.body0.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 149 */     this.body0.setTextureSize(64, 128);
/* 150 */     this.body0.mirror = true;
/* 151 */     setRotation(this.body0, 0.0523599F, 0.0F, 0.0F);
/* 152 */     this.lf1 = new ModelRenderer(this, 45, 32);
/* 153 */     this.lf1.addBox(-1.0F, 0.0F, -2.0F, 4, 3, 3);
/* 154 */     this.lf1.setRotationPoint(4.0F, 14.0F, -7.0F);
/* 155 */     this.lf1.setTextureSize(64, 128);
/* 156 */     this.lf1.mirror = true;
/* 157 */     setRotation(this.lf1, 0.0F, 0.0F, 0.0F);
/* 158 */     this.rf1 = new ModelRenderer(this, 45, 32);
/* 159 */     this.rf1.addBox(-3.0F, 0.0F, -2.0F, 4, 3, 3);
/* 160 */     this.rf1.setRotationPoint(-2.0F, 14.0F, -7.0F);
/* 161 */     this.rf1.setTextureSize(64, 128);
/* 162 */     this.rf1.mirror = true;
/* 163 */     setRotation(this.rf1, 0.0F, 0.0F, 0.0F);
/* 164 */     this.rb6 = new ModelRenderer(this, 30, 39);
/* 165 */     this.rb6.addBox(-3.5F, 7.0F, 2.0F, 2, 3, 1);
/* 166 */     this.rb6.setRotationPoint(-2.0F, 15.0F, 0.0F);
/* 167 */     this.rb6.setTextureSize(64, 128);
/* 168 */     this.rb6.mirror = true;
/* 169 */     setRotation(this.rb6, 0.1745329F, 0.0F, 0.0F);
/* 170 */     this.rb4 = new ModelRenderer(this, 20, 39);
/* 171 */     this.rb4.addBox(-2.0F, 3.0F, 6.0F, 1, 4, 1);
/* 172 */     this.rb4.setRotationPoint(-2.0F, 15.0F, 0.0F);
/* 173 */     this.rb4.setTextureSize(64, 128);
/* 174 */     this.rb4.mirror = true;
/* 175 */     setRotation(this.rb4, -0.6283185F, 0.0F, 0.0F);
/* 176 */     this.rb5 = new ModelRenderer(this, 20, 39);
/* 177 */     this.rb5.addBox(-4.0F, 3.0F, 6.0F, 1, 4, 1);
/* 178 */     this.rb5.setRotationPoint(-2.0F, 15.0F, 0.0F);
/* 179 */     this.rb5.setTextureSize(64, 128);
/* 180 */     this.rb5.mirror = true;
/* 181 */     setRotation(this.rb5, -0.6283185F, 0.0F, 0.0F);
/* 182 */     this.lb6 = new ModelRenderer(this, 30, 39);
/* 183 */     this.lb6.addBox(0.5F, 7.0F, 2.0F, 2, 3, 1);
/* 184 */     this.lb6.setRotationPoint(5.0F, 15.0F, 0.0F);
/* 185 */     this.lb6.setTextureSize(64, 128);
/* 186 */     this.lb6.mirror = true;
/* 187 */     setRotation(this.lb6, 0.1745329F, 0.0F, 0.0F);
/* 188 */     this.lb5 = new ModelRenderer(this, 20, 39);
/* 189 */     this.lb5.addBox(2.0F, 3.0F, 6.0F, 1, 4, 1);
/* 190 */     this.lb5.setRotationPoint(5.0F, 15.0F, 0.0F);
/* 191 */     this.lb5.setTextureSize(64, 128);
/* 192 */     this.lb5.mirror = true;
/* 193 */     setRotation(this.lb5, -0.6283185F, 0.0F, 0.0F);
/* 194 */     this.lb4 = new ModelRenderer(this, 20, 39);
/* 195 */     this.lb4.addBox(0.0F, 3.0F, 6.0F, 1, 4, 1);
/* 196 */     this.lb4.setRotationPoint(5.0F, 15.0F, 0.0F);
/* 197 */     this.lb4.setTextureSize(64, 128);
/* 198 */     this.lb4.mirror = true;
/* 199 */     setRotation(this.lb4, -0.6283185F, 0.0F, 0.0F);
/* 200 */     this.head3 = new ModelRenderer(this, 38, 50);
/* 201 */     this.head3.addBox(0.0F, 0.0F, 0.0F, 4, 2, 8);
/* 202 */     this.head3.setRotationPoint(-1.0F, 15.0F, -13.0F);
/* 203 */     this.head3.setTextureSize(64, 128);
/* 204 */     this.head3.mirror = true;
/* 205 */     setRotation(this.head3, 0.5235988F, 0.0F, 0.0F);
/* 206 */     this.feather3 = new ModelRenderer(this, 25, 117);
/* 207 */     this.feather3.addBox(0.0F, 0.0F, 1.0F, 1, 2, 9);
/* 208 */     this.feather3.setRotationPoint(1.0F, 12.0F, -8.0F);
/* 209 */     this.feather3.setTextureSize(64, 128);
/* 210 */     this.feather3.mirror = true;
/* 211 */     setRotation(this.feather3, 0.3490659F, 0.2617994F, 0.0F);
/* 212 */     this.feather1 = new ModelRenderer(this, 34, 100);
/* 213 */     this.feather1.addBox(0.0F, 0.0F, 1.0F, 1, 2, 9);
/* 214 */     this.feather1.setRotationPoint(0.0F, 12.0F, -8.0F);
/* 215 */     this.feather1.setTextureSize(64, 128);
/* 216 */     this.feather1.mirror = true;
/* 217 */     setRotation(this.feather1, 0.3490659F, -0.2617994F, 0.0F);
/* 218 */     this.feather2 = new ModelRenderer(this, 0, 116);
/* 219 */     this.feather2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
/* 220 */     this.feather2.setRotationPoint(0.5F, 11.0F, -6.0F);
/* 221 */     this.feather2.setTextureSize(64, 128);
/* 222 */     this.feather2.mirror = true;
/* 223 */     setRotation(this.feather2, 0.3490659F, 0.0F, 0.0F);
/* 224 */     this.head1 = new ModelRenderer(this, 38, 41);
/* 225 */     this.head1.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4);
/* 226 */     this.head1.setRotationPoint(-1.0F, 15.0F, -15.0F);
/* 227 */     this.head1.setTextureSize(64, 128);
/* 228 */     this.head1.mirror = true;
/* 229 */     setRotation(this.head1, 0.1396263F, 0.0F, 0.0F);
/* 230 */     this.rf2 = new ModelRenderer(this, 19, 58);
/* 231 */     this.rf2.addBox(-3.0F, 0.0F, 0.0F, 3, 3, 6);
/* 232 */     this.rf2.setRotationPoint(-2.0F, 14.0F, -7.0F);
/* 233 */     this.rf2.setTextureSize(64, 128);
/* 234 */     this.rf2.mirror = true;
/* 235 */     setRotation(this.rf2, -0.4886922F, 0.0F, 0.0F);
/* 236 */     this.rf3 = new ModelRenderer(this, 19, 47);
/* 237 */     this.rf3.addBox(-3.0F, -7.0F, 0.0F, 3, 3, 6);
/* 238 */     this.rf3.setRotationPoint(-2.0F, 14.0F, -7.0F);
/* 239 */     this.rf3.setTextureSize(64, 128);
/* 240 */     this.rf3.mirror = true;
/* 241 */     setRotation(this.rf3, -2.347623F, 0.0F, 0.0F);
/* 242 */     this.rf4 = new ModelRenderer(this, 20, 39);
/* 243 */     this.rf4.addBox(0.0F, 6.0F, 4.0F, 1, 4, 1);
/* 244 */     this.rf4.setRotationPoint(-3.0F, 14.0F, -7.0F);
/* 245 */     this.rf4.setTextureSize(64, 128);
/* 246 */     this.rf4.mirror = true;
/* 247 */     setRotation(this.rf4, -0.6283185F, 0.0F, 0.0F);
/* 248 */     this.rf5 = new ModelRenderer(this, 20, 39);
/* 249 */     this.rf5.addBox(-2.0F, 6.0F, 4.0F, 1, 4, 1);
/* 250 */     this.rf5.setRotationPoint(-3.0F, 14.0F, -7.0F);
/* 251 */     this.rf5.setTextureSize(64, 128);
/* 252 */     this.rf5.mirror = true;
/* 253 */     setRotation(this.rf5, -0.6283185F, 0.0F, 0.0F);
/* 254 */     this.rf6 = new ModelRenderer(this, 30, 39);
/* 255 */     this.rf6.addBox(-2.5F, 6.0F, 0.0F, 2, 5, 1);
/* 256 */     this.rf6.setRotationPoint(-2.0F, 14.0F, -7.0F);
/* 257 */     this.rf6.setTextureSize(64, 128);
/* 258 */     this.rf6.mirror = true;
/* 259 */     setRotation(this.rf6, 0.1745329F, 0.0F, 0.0F);
/* 260 */     this.lf2 = new ModelRenderer(this, 19, 58);
/* 261 */     this.lf2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 6);
/* 262 */     this.lf2.setRotationPoint(4.0F, 14.0F, -7.0F);
/* 263 */     this.lf2.setTextureSize(64, 128);
/* 264 */     this.lf2.mirror = true;
/* 265 */     setRotation(this.lf2, -0.4886922F, 0.0F, 0.0F);
/* 266 */     this.lf3 = new ModelRenderer(this, 19, 47);
/* 267 */     this.lf3.addBox(0.0F, -7.0F, 0.0F, 3, 3, 6);
/* 268 */     this.lf3.setRotationPoint(4.0F, 14.0F, -7.0F);
/* 269 */     this.lf3.setTextureSize(64, 128);
/* 270 */     this.lf3.mirror = true;
/* 271 */     setRotation(this.lf3, -2.347623F, 0.0F, 0.0F);
/* 272 */     this.lf4 = new ModelRenderer(this, 20, 39);
/* 273 */     this.lf4.addBox(0.0F, 6.0F, 4.0F, 1, 4, 1);
/* 274 */     this.lf4.setRotationPoint(4.0F, 14.0F, -7.0F);
/* 275 */     this.lf4.setTextureSize(64, 128);
/* 276 */     this.lf4.mirror = true;
/* 277 */     setRotation(this.lf4, -0.6283185F, 0.0F, 0.0F);
/* 278 */     this.lf5 = new ModelRenderer(this, 20, 39);
/* 279 */     this.lf5.addBox(2.0F, 6.0F, 4.0F, 1, 4, 1);
/* 280 */     this.lf5.setRotationPoint(4.0F, 14.0F, -7.0F);
/* 281 */     this.lf5.setTextureSize(64, 128);
/* 282 */     this.lf5.mirror = true;
/* 283 */     setRotation(this.lf5, -0.6283185F, 0.0F, 0.0F);
/* 284 */     this.lf6 = new ModelRenderer(this, 30, 39);
/* 285 */     this.lf6.addBox(0.5F, 6.0F, -2.0F, 2, 5, 1);
/* 286 */     this.lf6.setRotationPoint(4.0F, 14.0F, -5.0F);
/* 287 */     this.lf6.setTextureSize(64, 128);
/* 288 */     this.lf6.mirror = true;
/* 289 */     setRotation(this.lf6, 0.1745329F, 0.0F, 0.0F);
/* 290 */     this.head2 = new ModelRenderer(this, 19, 80);
/* 291 */     this.head2.addBox(-1.0F, 16.0F, -16.0F, 4, 1, 5);
/* 292 */     this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 293 */     this.head2.setTextureSize(64, 128);
/* 294 */     this.head2.mirror = true;
/* 295 */     setRotation(this.head2, 0.1047198F, 0.0F, 0.0F);
/* 296 */     this.tail1 = new ModelRenderer(this, 9, 18);
/* 297 */     this.tail1.addBox(-1.0F, -1.0F, -3.0F, 2, 8, 2);
/* 298 */     this.tail1.setRotationPoint(1.0F, 15.0F, 9.0F);
/* 299 */     this.tail1.setTextureSize(64, 128);
/* 300 */     this.tail1.mirror = true;
/* 301 */     setRotation(this.tail1, 1.095163F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 309 */     Hydrolisc c = (Hydrolisc)entity;
/* 310 */     float hf = 0.0F;
/* 311 */     float newangle = 0.0F;
/*     */     
/* 313 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 314 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 317 */     if (f1 > 0.1D) {
/* 318 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 320 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 324 */     this.lf1.rotateAngleX = newangle;
/* 325 */     this.lf2.rotateAngleX = newangle - 0.488F;
/* 326 */     this.lf3.rotateAngleX = newangle - 2.347F;
/* 327 */     this.lf4.rotateAngleX = newangle - 0.628F;
/* 328 */     this.lf5.rotateAngleX = newangle - 0.628F;
/* 329 */     this.lf6.rotateAngleX = newangle + 0.174F;
/*     */     
/* 331 */     this.rf1.rotateAngleX = -newangle;
/* 332 */     this.rf2.rotateAngleX = -newangle - 0.488F;
/* 333 */     this.rf3.rotateAngleX = -newangle - 2.347F;
/* 334 */     this.rf4.rotateAngleX = -newangle - 0.628F;
/* 335 */     this.rf5.rotateAngleX = -newangle - 0.628F;
/* 336 */     this.rf6.rotateAngleX = -newangle + 0.174F;
/*     */     
/* 338 */     this.lb1.rotateAngleX = -newangle;
/* 339 */     this.lb2.rotateAngleX = -newangle - 0.488F;
/* 340 */     this.lb3.rotateAngleX = -newangle - 2.347F;
/* 341 */     this.lb4.rotateAngleX = -newangle - 0.628F;
/* 342 */     this.lb5.rotateAngleX = -newangle - 0.628F;
/* 343 */     this.lb6.rotateAngleX = -newangle + 0.174F;
/*     */     
/* 345 */     this.rb1.rotateAngleX = newangle;
/* 346 */     this.rb2.rotateAngleX = newangle - 0.488F;
/* 347 */     this.rb3.rotateAngleX = newangle - 2.347F;
/* 348 */     this.rb4.rotateAngleX = newangle - 0.628F;
/* 349 */     this.rb5.rotateAngleX = newangle - 0.628F;
/* 350 */     this.rb6.rotateAngleX = newangle + 0.174F;
/*     */ 
/*     */     
/* 353 */     newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 354 */     if (c.isSitting() == true) {
/* 355 */       newangle = 0.0F;
/*     */     }
/* 357 */     this.tail1.rotateAngleY = newangle * 0.25F;
/* 358 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 5.0F;
/* 359 */     this.tail1.rotationPointX += (float)Math.sin(this.tail1.rotateAngleY) * 5.0F;
/* 360 */     this.tail2.rotateAngleY = newangle * 0.5F;
/* 361 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 8.0F;
/* 362 */     this.tail2.rotationPointX += (float)Math.sin(this.tail2.rotateAngleY) * 8.0F;
/* 363 */     this.tail3.rotateAngleY = newangle * 0.75F;
/*     */ 
/*     */     
/* 366 */     hf = c.getHydroHealth() / c.getMaxHealth();
/* 367 */     newangle = MathHelper.cos(f2 * 1.25F * this.wingspeed * hf) * 3.1415927F * 0.2F * hf;
/* 368 */     this.feather2.rotateAngleY = newangle;
/* 369 */     newangle = MathHelper.cos(f2 * 0.75F * this.wingspeed * hf) * 3.1415927F * 0.2F * hf;
/* 370 */     this.feather1.rotateAngleY = newangle - 0.9F;
/* 371 */     this.feather3.rotateAngleY = -newangle + 0.9F;
/*     */ 
/*     */     
/* 374 */     this.tail2.render(f5);
/* 375 */     this.tail3.render(f5);
/* 376 */     this.body2.render(f5);
/* 377 */     this.lb2.render(f5);
/* 378 */     this.lb1.render(f5);
/* 379 */     this.spine3.render(f5);
/* 380 */     this.spine4.render(f5);
/* 381 */     this.rb1.render(f5);
/* 382 */     this.rb2.render(f5);
/* 383 */     this.spine1.render(f5);
/* 384 */     this.spine2.render(f5);
/* 385 */     this.lb3.render(f5);
/* 386 */     this.rb3.render(f5);
/* 387 */     this.body1.render(f5);
/* 388 */     this.body0.render(f5);
/* 389 */     this.lf1.render(f5);
/* 390 */     this.rf1.render(f5);
/* 391 */     this.rb6.render(f5);
/* 392 */     this.rb4.render(f5);
/* 393 */     this.rb5.render(f5);
/* 394 */     this.lb6.render(f5);
/* 395 */     this.lb5.render(f5);
/* 396 */     this.lb4.render(f5);
/* 397 */     this.head3.render(f5);
/* 398 */     this.feather3.render(f5);
/* 399 */     this.feather1.render(f5);
/* 400 */     this.feather2.render(f5);
/* 401 */     this.head1.render(f5);
/* 402 */     this.rf2.render(f5);
/* 403 */     this.rf3.render(f5);
/* 404 */     this.rf4.render(f5);
/* 405 */     this.rf5.render(f5);
/* 406 */     this.rf6.render(f5);
/* 407 */     this.lf2.render(f5);
/* 408 */     this.lf3.render(f5);
/* 409 */     this.lf4.render(f5);
/* 410 */     this.lf5.render(f5);
/* 411 */     this.lf6.render(f5);
/* 412 */     this.head2.render(f5);
/* 413 */     this.tail1.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 420 */     model.rotateAngleX = x;
/* 421 */     model.rotateAngleY = y;
/* 422 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 427 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelHydrolisc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */